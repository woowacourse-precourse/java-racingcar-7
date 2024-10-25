package racingcar.global.config;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import racingcar.Application;
import racingcar.global.annotation.Controller;
import racingcar.global.annotation.Service;

public class ProjectScanner {

    private static final Class<?> ROOT_CLASS = Application.class;

    private static final Set<String> EXCLUDE_CLASS_NAME = Set.of(BeanConfig.class.getName());

    private static final Set<Class<? extends Annotation>> BEAN_ANNOTATION_CLASS = Set.of(
            Controller.class,
            Service.class
    );


    public Set<Class<?>> getClassesForBeans() {
        Set<Class<?>> wholeClasses = scan();

        return BEAN_ANNOTATION_CLASS.stream()
                .flatMap(annotationClass -> findClassesForAnnotation(wholeClasses, annotationClass).stream())
                .collect(Collectors.toSet());
    }

    private Set<Class<?>> scan() {
        String rootPackageName = ROOT_CLASS.getPackage().getName();

        try {
            return getClasses(rootPackageName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Set<Class<?>> getClasses(String packageName) throws IOException, ClassNotFoundException {
        Set<Class<?>> classes = new HashSet<>();
        String path = packageName.replace('.', '/');

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if (classLoader == null) {
            throw new IllegalStateException("Cannot get ClassLoader.");
        }

        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            String protocol = resource.getProtocol();

            if ("file".equals(protocol)) {
                String filePath = URLDecoder.decode(resource.getPath(), StandardCharsets.UTF_8);
                findClassesInDirectory(packageName, filePath, classes);
            } else if ("jar".equals(protocol)) {
                findClassesInJar(packageName, resource, classes);
            }
        }

        return classes;
    }

    private void findClassesInDirectory(String packageName, String directoryPath, Set<Class<?>> classes) throws ClassNotFoundException {
        File directory = new File(directoryPath);
        if (!directory.exists()) return;

        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            processFile(packageName, file, classes);
        }
    }

    private void processFile(String packageName, File file, Set<Class<?>> classes) throws ClassNotFoundException {
        if (file.isDirectory()) {
            findClassesInDirectory(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
        } else if (file.getName().endsWith(".class")) {
            addClassToSet(packageName, file, classes);
        }
    }

    private void addClassToSet(String packageName, File file, Set<Class<?>> classes) throws ClassNotFoundException {
        String fileName = file.getName().substring(0, file.getName().length() - 6);
        if (EXCLUDE_CLASS_NAME.contains(fileName)) {
            return;
        }

        String className = packageName + '.' + fileName;
        classes.add(Class.forName(className));
    }

    private void findClassesInJar(String packageName, URL resource, Set<Class<?>> classes)
            throws IOException, ClassNotFoundException {
        JarURLConnection jarConn = (JarURLConnection) resource.openConnection();
        try (JarFile jarFile = jarConn.getJarFile()) {
            Enumeration<JarEntry> entries = jarFile.entries();
            String path = packageName.replace('.', '/');
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String entryName = entry.getName();

                // 해당 패키지 및 하위 패키지의 클래스만 처리
                registerClassInJar(entryName, path, entry, classes);
            }
        }
    }

    private void registerClassInJar(String entryName, String path, JarEntry entry, Set<Class<?>> classes)
            throws ClassNotFoundException {
        if (entryName.startsWith(path) && entryName.endsWith(".class") && !entry.isDirectory()) {
            String className = entryName.replace('/', '.').substring(0, entryName.length() - 6);
            classes.add(Class.forName(className));
        }
    }

    private static Set<Class<?>> findClassesForAnnotation(Set<Class<?>> classes,
                                                          Class<? extends Annotation> annotationClass) {
        return classes.stream()
                .filter(clazz -> clazz.isAnnotationPresent(annotationClass))
                .collect(Collectors.toSet());
    }
}
