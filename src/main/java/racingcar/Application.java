package racingcar;

import racingcar.controller.RaceController;
import racingcar.config.RaceControllerFactory;

public class Application {
    public static void main(String[] args) {
        RaceController controller = RaceControllerFactory.createRaceController();
        controller.startRace();
    }
}
