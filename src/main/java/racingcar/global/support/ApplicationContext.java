package racingcar.global.support;

import java.util.Set;

public class ApplicationContext {

    public static void init() {
        clearBeanContainer();
        ProjectScanner projectScanner = new ProjectScanner();
        Set<Class<?>> classesToBeBeans = projectScanner.getClassesForBeans();
        BeanConfig.registerBeanContainer(classesToBeBeans);
    }

    private static void clearBeanContainer() {
        BeanConfig.clear();
    }
}
