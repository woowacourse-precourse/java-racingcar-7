package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;

public class GameController {

    private final MoveStrategy moveStrategy;

    public GameController(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        final String carNames = InputView.getCarNames();
        final int numberOfAttempts = InputView.getNumberOfAttempts();

        final Cars cars = new Cars(carNames);
        final RacingGame racingGame = new RacingGame(cars, moveStrategy, numberOfAttempts);

        racingGame.play();
    }
}
