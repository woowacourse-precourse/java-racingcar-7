package racingcar;

import java.util.List;

public class Race {
    private final List<Car> CARS;
    private final int COUNT;

    Race(List<Car> cars, int count) {
        this.CARS = cars;
        this.COUNT = count;
    }
}
