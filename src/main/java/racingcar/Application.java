package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        RacingController racingController = appConfig.racingController();
        racingController.start();
    }
}
