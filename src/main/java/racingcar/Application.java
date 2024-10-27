package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.model.move.MoveStrategy;
import racingcar.model.move.RandomMoveStrategy;

public class Application {

    public static void main(String[] args) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        RacingGameController racingGameController = new RacingGameController(moveStrategy);
        racingGameController.start();
    }
}
