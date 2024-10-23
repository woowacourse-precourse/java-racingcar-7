package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.GameControllerFactory;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameControllerFactory.create();

        gameController.start();
    }
}
