package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.strategy.MovingStrategy;

public class Race {
    private final Cars cars;
    private final int attempts;

    public Race(Cars cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start(MovingStrategy strategy) {
        for (int i = 0; i < attempts; i++) {
            cars.race(strategy);
        }
    }
}
