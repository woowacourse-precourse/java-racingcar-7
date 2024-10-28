package racingcar;

import racingcar.domain.controller.GameController;
import racingcar.domain.strategy.RandomMovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputView(),
                new ResultView(),
                new RandomMovingStrategy()
        );
        gameController.play();
    }
}
