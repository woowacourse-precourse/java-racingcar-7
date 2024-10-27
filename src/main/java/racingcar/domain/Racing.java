package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private final List<Car> cars;

    public Racing(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinners() {
        final int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
