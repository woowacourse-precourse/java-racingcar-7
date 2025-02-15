package racingcar;

import racingcar.config.RacingCarAppConfig;
import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarAppConfig config = new RacingCarAppConfig();
        RacingCarController raceGame = config.raceGame();

        raceGame.start();
    }
}
