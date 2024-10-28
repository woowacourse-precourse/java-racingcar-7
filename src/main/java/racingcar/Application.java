package racingcar;

import racingcar.config.Config;
import racingcar.controller.RacingController;

public class Application {

    public static void main(String[] args) {
        Config config = new Config();
        RacingController controller = config.racingController();

        controller.executeRace();
    }
}
