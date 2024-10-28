package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = AppConfig.createRacingGameController();
        controller.start();
    }
}

