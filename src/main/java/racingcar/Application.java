package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        String tryCount = InputView.inputTryCount();
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        RacingGame racingGame = new RacingGame(carNames, tryCount, moveStrategy);
        racingGame.start();
    }
}
