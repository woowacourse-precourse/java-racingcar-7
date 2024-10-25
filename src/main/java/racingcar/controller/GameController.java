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
        String carNames = InputView.getCarNames();
        Cars cars = new Cars(carNames);

        int numberOfAttempts = InputView.getNumberOfAttempts();
        RacingGame racingGame = new RacingGame(cars, moveStrategy, numberOfAttempts);

        racingGame.play();
    }
}
