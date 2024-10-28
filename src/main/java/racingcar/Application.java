package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        final GameController gameController = new GameController(new RandomMoveStrategy());
        gameController.run();
    }
}
