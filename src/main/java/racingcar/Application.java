package racingcar;

import racingcar.controller.GameController;
import racingcar.model.RaceCars;

public class Application {
    public static void main(String[] args) {
        final RaceCars raceCars = new RaceCars();

        final GameController gameController = new GameController(raceCars);
        gameController.start();
    }
}
