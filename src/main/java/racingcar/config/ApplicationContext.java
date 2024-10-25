package racingcar.config;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import racingcar.config.annotation.Component;

/**
 * 어플리케이션의 빈을 생성하고 관리하는 클래스
 */
public class ApplicationContext {

    private static final Map<Class<?>, ApplicationContext> instances = new ConcurrentHashMap<>();
    private static final Class<? extends Annotation> COMPONENT_ANNOTATION = Component.class;

    private final List<Class<?>> components;
    private final Map<Class<?>, Object> beans = new ConcurrentHashMap<>();

    private ApplicationContext(Class<?> baseClass) {
        this.components = scanComponents(baseClass);
    }

    public static ApplicationContext getInstance(Class<?> baseClass) {
        return instances.computeIfAbsent(baseClass, ApplicationContext::new);
    }

    public <T> T getBean(Class<T> cls) {
        return cls.cast(beans.computeIfAbsent(cls, this::createBean));
    }

    private List<Class<?>> scanComponents(Class<?> baseClass) {
        ClassPathScanner scanner = ClassPathScanner.getInstance(baseClass);

        return scanner.scan(this::isComponent);
    }

    private boolean isComponent(Class<?> cls) {
        return Arrays.stream(cls.getAnnotations())
                .map(Annotation::annotationType)
                .anyMatch(it -> it.isAnnotationPresent(COMPONENT_ANNOTATION));
    }

    private <T> T createBean(Class<T> cls) {
        try {
            if (cls.isInterface()) {
                Optional<Class<?>> implementation = findImplementationClass(cls);

                return implementation.map(it -> cls.cast(createBean(it)))
                        .orElseThrow(ClassNotFoundException::new);
            }

            Constructor<?> constructor = extractConstructor(cls);
            List<Object> parameters = createConstructorParameters(constructor);

            return cls.cast(constructor.newInstance(parameters.toArray()));
        } catch (Exception e) {
            return null;
        }
    }

    private Constructor<?> extractConstructor(Class<?> cls) throws NoSuchMethodException {
        Constructor<?>[] constructors = cls.getDeclaredConstructors();
        if (constructors.length == 0) {
            return cls.getDeclaredConstructor();
        }

        return constructors[0];
    }

    private List<Object> createConstructorParameters(Constructor<?> constructor) {
        List<Class<?>> parameterClasses = resolveConstructorParameters(constructor);

        return parameterClasses.stream()
                .map(this::createBean)
                .collect(Collectors.toList());
    }

    private List<Class<?>> resolveConstructorParameters(Constructor<?> constructor) {
        return List.of(constructor.getParameterTypes());
    }

    private Optional<Class<?>> findImplementationClass(Class<?> interfaceType) {
        return components.stream()
                .filter(interfaceType::isAssignableFrom)
                .findFirst();
    }
}