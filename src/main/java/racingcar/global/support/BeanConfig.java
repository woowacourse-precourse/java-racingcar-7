package racingcar.global.support;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BeanConfig {

    private static final Map<Class<?>, Class<?>> interfaceImplementationMap = new HashMap<>();

    private static final Map<Class<?>, Object> beanContainer = new HashMap<>();

    private static final Set<Class<?>> currentRegisterLog = new HashSet<>(); // 순환 참조 검사를 위한 Set 객체

    public static void clear() {
        interfaceImplementationMap.clear();
        beanContainer.clear();
        currentRegisterLog.clear();
    }


    public static void registerBeanContainer(Set<Class<?>> classesToBeBeans) {
        classesToBeBeans.forEach(clazz -> {
            if (interfaceImplementationMap.containsKey(clazz)) {
                throw new IllegalArgumentException(String.format("%s에 해당하는 bean 설정이 이미 존재합니다.", clazz));
            }

            interfaceImplementationMap.put(clazz, clazz);
            findInterfacesRecursively(clazz).forEach(myInterface -> interfaceImplementationMap.put(myInterface, clazz));
        });

        interfaceImplementationMap.keySet().forEach(BeanConfig::registerBean);
    }

    private static Set<Class<?>> findInterfacesRecursively(Class<?> clazz) {
        return Arrays.stream(clazz.getInterfaces())
                .flatMap(myInterface -> {
                    Set<Class<?>> superInterfaces = findInterfacesRecursively(myInterface);
                    superInterfaces.add(myInterface);

                    return superInterfaces.stream();
                }).collect(Collectors.toSet());
    }

    // bean을 생성하고 등록
    private static void registerBean(Class<?> abstractClass) {
        if (beanContainer.containsKey(abstractClass)) {
            return;
        }

        if (currentRegisterLog.contains(abstractClass)) {
            throw new IllegalStateException("순환 참조가 발생했습니다.");
        }
        currentRegisterLog.add(abstractClass);

        if (!interfaceImplementationMap.containsKey(abstractClass)) {
            throw new IllegalStateException(String.format("%s에 해당하는 bean 설정이 존재하지 않습니다.", abstractClass));
        }
        Class<?> specificClass = interfaceImplementationMap.get(abstractClass);

        // 현재는 하나의 생성자만 허용
        Constructor<?> constructor = specificClass.getConstructors()[0];
        List<Class<?>> parameterTypes = Arrays.stream(constructor.getParameterTypes()).toList();

        List<Object> dependencies = parameterTypes.stream().map(dependency -> {
            if (!beanContainer.containsKey(dependency)) {
                registerBean(dependency);
            }

            return beanContainer.get(dependency);
        }).toList();

        try {
            Object beanInstance = constructor.newInstance(dependencies.toArray());
            beanContainer.put(abstractClass, beanInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        currentRegisterLog.remove(abstractClass);
    }


    public static <T> T getBean(Class<T> clazz) {
        Class<?> implementClass = interfaceImplementationMap.get(clazz);
        if (implementClass == null) {
            throw new IllegalArgumentException(String.format("%s의 bean이 존재하지 않습니다.", clazz.getName()));
        }

        Object beanObject = beanContainer.get(implementClass);
        if (beanObject != null) {
            return clazz.cast(beanObject);
        }

        throw new IllegalArgumentException(String.format("%s의 bean이 존재하지 않습니다.", clazz.getName()));
    }
}
