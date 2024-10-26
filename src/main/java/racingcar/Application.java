package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.Controller;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.createController();

        controller.startGame();
    }
}
