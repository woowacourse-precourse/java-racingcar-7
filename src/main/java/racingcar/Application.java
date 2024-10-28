package racingcar;

import racingcar.config.AppConfig;
import racingcar.controller.RacingcarController;

public class Application {
    public static void main(String[] args) {
        RacingcarController racingcarController = AppConfig.createRacingcarController();
        racingcarController.startRace();
    }
}
