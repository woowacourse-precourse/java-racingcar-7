package racingcar.model;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int attemptCount;

    public Game(List<Car> cars, int attemptCount) {
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
