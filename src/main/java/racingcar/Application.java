package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.validation.AttemptCountValidator;
import racingcar.validation.CarNamesValidator;
import racingcar.view.RacingGameView;

public class Application {
    public static void main(String[] args) {
        RacingGameView racingGameView = new RacingGameView();
        CarNamesValidator carNamesValidator = new CarNamesValidator();
        AttemptCountValidator attemptCountValidator = new AttemptCountValidator();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        new RacingGameController(
            racingGameView,
            carNamesValidator,
            attemptCountValidator,
            moveStrategy
        ).play();
    }
}
