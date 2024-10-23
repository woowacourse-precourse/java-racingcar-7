package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void start() {
        cars.forEach(Car::move);
    }
}
