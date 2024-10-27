package racingcar.domain;

import java.util.List;

public class Game {
    private final int tryCount;
    private final List<Car> cars;

    public Game(int tryCount, List<Car> cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void run() {
        cars.forEach(Car::move);
    }
}
