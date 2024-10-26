package racingcar;

import racingcar.config.ObjectFactory;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = ObjectFactory.createGameController();
        gameController.run();
    }
}
