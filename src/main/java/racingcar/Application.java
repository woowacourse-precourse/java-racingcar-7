package racingcar;

import racingcar.config.ApplicationConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        RacingCarController racingCarController = applicationConfig.racingCarController();
        racingCarController.run();
    }
}
