package racingcar.domain;

import racingcar.controller.GameController;
import racingcar.domain.strategy.DefaultRandomGenerator;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        MoveStrategy moveStrategy = new RandomMoveStrategy(
                new DefaultRandomGenerator());

        GameController gameController = new GameController(
                inputView, outputView, moveStrategy);
        gameController.start();
    }
}
