package racingcar;


import racingcar.common.config.GameFactory;
import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = GameFactory.createGameController();
        gameController.run();
    }
}
