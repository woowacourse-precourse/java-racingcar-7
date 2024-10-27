package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.AttemptCount;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final MoveStrategy moveStrategy;

    public GameController(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        final String carNames = InputView.getCarNames();
        final int numberOfAttempts = InputView.getNumberOfAttempts();

        final Cars cars = new Cars(carNames);
        final AttemptCount attemptCount = new AttemptCount(numberOfAttempts);

        OutputView.printRaceStart();
        playRounds(cars, attemptCount);
        OutputView.printWinners(cars.getWinners());
    }

    private void playRounds(Cars cars, AttemptCount attemptCount) {
        IntStream.range(0, attemptCount.numberOfAttempts())
                .forEach(i -> {
                    cars.attemptCarMovements(moveStrategy);
                    OutputView.printRaceProgress(cars.get());
                });
    }
}
