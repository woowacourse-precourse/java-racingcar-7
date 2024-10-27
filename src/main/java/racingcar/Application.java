package racingcar;

import racingcar.common.factory.GameFactory;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameFactory factory = new GameFactory();

        GameController gameController = factory.gameController();
        gameController.run();
    }
}
