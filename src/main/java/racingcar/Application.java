package racingcar;

import racingcar.server.config.AppConfig;
import racingcar.server.controller.MainController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        MainController mainController = appConfig.initializeMainController();
        mainController.run();
    }
}
