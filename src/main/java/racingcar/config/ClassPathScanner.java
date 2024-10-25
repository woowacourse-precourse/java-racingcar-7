package racingcar.config;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 클래스 패스로부터 모든 클래스를 스캔하는 클래스
 */
public class ClassPathScanner {

    private static final Map<Class<?>, ClassPathScanner> instances = new ConcurrentHashMap<>();

    private final Class<?> baseClass;

    private ClassPathScanner(Class<?> baseClass) {
        this.baseClass = baseClass;
    }

    public static ClassPathScanner getInstance(Class<?> baseClass) {
        return instances.computeIfAbsent(baseClass, ClassPathScanner::new);
    }

    public List<Class<?>> scan(Predicate<Class<?>> filter) {
        List<File> entryPoint = getEntryPoint();

        return entryPoint.stream()
                .map(this::findClass)
                .flatMap(List::stream)
                .filter(filter)
                .collect(Collectors.toList());
    }

    private List<File> getEntryPoint() {
        String basePackageName = baseClass.getPackage().getName();

        return getClassPath().stream()
                .map(it -> new File(it, basePackageName))
                .filter(File::exists)
                .collect(Collectors.toList());
    }

    private List<String> getClassPath() {
        return Arrays.stream(System.getProperty("java.class.path").split(":"))
                .filter(it -> !it.endsWith(".jar"))
                .collect(Collectors.toList());
    }

    private List<Class<?>> findClass(File base) {
        if (base.exists() && base.isDirectory()) {
            List<File> children = findFilesFromDirectory(base);

            return children.stream()
                    .map(this::findClass)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }

        if (base.exists() && base.isFile()) {
            Class<?> cls = extractClassFromFile(base).orElse(null);
            if (cls != null) {
                return List.of(cls);
            }
            return List.of();
        }

        return List.of();
    }

    private List<File> findFilesFromDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files == null) {
            return List.of();
        }

        return List.of(files);
    }

    private Optional<Class<?>> extractClassFromFile(File file) {
        try {
            String classPackage = extractClassPackageFromFile(file);
            Class<?> cls = Class.forName(classPackage);

            return Optional.of(cls);
        } catch (ClassNotFoundException e) {
            return Optional.empty();
        }
    }

    private String extractClassPackageFromFile(File file) {
        String classPathReg = String.join("|", getClassPath());

        return file.getAbsolutePath()
                .replaceAll(classPathReg, "")
                .replaceAll(".class", "")
                .replaceFirst("/", "")
                .replace(File.separator, ".");
    }
}
