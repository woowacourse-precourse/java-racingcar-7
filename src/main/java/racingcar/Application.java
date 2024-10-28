package racingcar;

import racingcar.controller.GameController;
import racingcar.movableStrategy.BasicMoveStrategy;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new BasicMoveStrategy());

        gameController.gameSetting();
        gameController.gamePlay();
        gameController.gameResult();

    }
}
