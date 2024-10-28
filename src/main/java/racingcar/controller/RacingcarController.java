package racingcar.controller;

import racingcar.model.AttemptCount;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.car.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {

    public void run() {
        OutputView.printInputCarNamesMessage();
        Cars cars = new Cars(InputView.readInput(), new RandomMoveStrategy());

        OutputView.printInputAttemptCountMessage();
        AttemptCount attemptCount = AttemptCount.fromString(InputView.readInput());

        RacingGame racingGame = new RacingGame(cars, attemptCount);
        racingGame.play();

        OutputView.printRacingResult(racingGame.getRoundResults(), racingGame.getWinnerNames());
    }
}
