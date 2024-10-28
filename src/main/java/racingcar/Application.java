package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.movement.RandomMovementGenerator;
import racingcar.domain.random_number.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputView(),
                new OutputView(),
                new RandomMovementGenerator(RandomNumberGenerator.getInstance())
        );

        gameController.play();
    }
}
