package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int tryCount;

    public Race(List<String> carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
