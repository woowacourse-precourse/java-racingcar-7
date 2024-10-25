package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.CarGameController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CarGameController carGameController = appConfig.getController();
        carGameController.run();
    }
}
