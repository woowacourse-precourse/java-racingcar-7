package racingcar.domain;

import racingcar.strategy.MovingStrategy;

public class Race {
    private final Cars cars;
    private final RoundProgress roundProgress;

    private Race(Cars cars, RoundProgress roundProgress) {
        this.cars = cars;
        this.roundProgress = roundProgress;
    }

    public static Race of(Cars cars, RoundProgress roundProgress) {
        return new Race(cars, roundProgress);
    }

    public void execute(MovingStrategy movingStrategy) {
        do {
            executeRound(movingStrategy);
        } while (roundProgress.hasNext());
    }

    private void executeRound(MovingStrategy movingStrategy) {
        cars.attemptMoveAll(movingStrategy);
        roundProgress.progress();
    }
}
