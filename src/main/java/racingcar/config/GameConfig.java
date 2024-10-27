package racingcar.config;

import racingcar.model.Car;

import java.util.List;

public class GameConfig {
    private final List<Car> cars;
    private final int attemptCount;

    public GameConfig(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
