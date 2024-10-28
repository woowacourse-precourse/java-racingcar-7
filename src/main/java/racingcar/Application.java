package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.movement.MovementStrategy;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.view.input.RacingGameInput;
import racingcar.view.output.OutputView;
import racingcar.view.output.RacingGameOutPutView;

public class Application {
    public static void main(String[] args) {
        RacingGameInput inputView = new RacingGameInput();
        OutputView outputView = new RacingGameOutPutView();
        MovementStrategy movementStrategy = new RandomMovementStrategy();

        RacingGameController controller = new RacingGameController(inputView, outputView, movementStrategy);
        controller.start();
    }
}
