package racingcar.config;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.config.annotation.Component;

/**
 * Component Scan 구현
 */
public class ComponentScanner {

    private static final Class<? extends Annotation> COMPONENT_ANNOTATION = Component.class;

    private ComponentScanner() {
    }

    /**
     * Java Class Path를 기준으로 Component Scan을 진행한다.
     *
     * @param cls 기준 클래스
     * @return 스캔된 클래스 리스트
     */
    public static List<Class<?>> scan(Class<?> cls) {
        return Arrays.stream(System.getProperty("java.class.path").split(":"))
                .filter(it -> !it.endsWith(".jar"))
                .map(it -> process("", new File(it + "/" + cls.getPackage().getName())))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * Component 어노테이션이 포함된 클래스를 찾는다.
     *
     * @param packageName 기준 패키지
     * @param file        기준 파일
     * @return 스캔된 클래스 리스트
     */
    private static List<Class<?>> process(String packageName, File file) {
        if (file.exists() && file.isDirectory()) {
            return Arrays.stream(Objects.requireNonNull(file.listFiles()))
                    .map(it -> process(packageName.isEmpty() ? file.getName() : packageName + "." + file.getName(), it))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }

        if (file.exists() && file.isFile() && file.getName().endsWith(".class")) {
            try {
                String className = packageName + "." + file.getName().replace(".class", "");
                Class<?> cls = Class.forName(className);
                if (isComponent(cls)) {
                    return List.of(cls);
                }
            } catch (ClassNotFoundException e) {
                return List.of();
            }
        }

        return List.of();
    }

    private static boolean isComponent(Class<?> cls) {
        return Arrays.stream(cls.getAnnotations())
                .map(Annotation::annotationType)
                .anyMatch(it -> it.isAnnotationPresent(COMPONENT_ANNOTATION));
    }
}