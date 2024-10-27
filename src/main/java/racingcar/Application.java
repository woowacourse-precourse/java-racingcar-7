package racingcar;

import racingcar.global.support.ApplicationContext;
import racingcar.global.support.FrontController;

public class Application {

    public static void main(String[] args)  {
        ApplicationContext.init();

        FrontController frontController = new FrontController();
        frontController.run();
    }
}
