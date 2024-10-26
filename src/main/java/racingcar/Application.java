package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        final AppConfig appConfig = new AppConfig();
        final RacingCarController racingCarController = appConfig.racingCarController();
        racingCarController.start();
    }
}
