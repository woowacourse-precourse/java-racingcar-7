package racingcar.global.frontController;

import java.util.Set;
import racingcar.global.config.BeanConfig;
import racingcar.global.config.ProjectScanner;

public final class FrontController {

    static {
        ProjectScanner projectScanner = new ProjectScanner();
        Set<Class<?>> classesToBeBeans = projectScanner.getClassesForBeans();
        BeanConfig.registerBeanContainer(classesToBeBeans);
    }

    public void run() {

    }
}
