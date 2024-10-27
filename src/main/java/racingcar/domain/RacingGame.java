package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.view.OutputView;

public class RacingGame {

    private static final int MIN_NUMBER_OF_ATTEMPTS = 1;
    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final int numberOfAttempts;

    public RacingGame(Cars cars, MoveStrategy moveStrategy, int numberOfAttempts) {
        validatePositiveNumber(numberOfAttempts);
        this.cars = cars;
        this.moveStrategy = moveStrategy;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void play() {
        OutputView.printRaceStart();
        IntStream.range(0, numberOfAttempts).forEach(i -> playRound());
        OutputView.printWinners(cars.getWinners());
    }

    private void playRound() {
        cars.attemptCarMovements(moveStrategy);
        OutputView.printRaceProgress(cars.get());
    }

    private void validatePositiveNumber(int number) {
        if (number < MIN_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
