package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.factory.RacingGameControllerFactory;

public class Application {
    public static void main(String[] args) {
        RacingGameController controller = RacingGameControllerFactory.createRacingGameController();
        controller.run();
    }

}
