package racingcar.presentation;

import racingcar.domain.car.Car;

import java.util.Set;
import java.util.stream.Collectors;

public class CarStatusFormatter {
    private static final String LINE_SEPARATOR = "\n";

    public String format(Set<Car> cars) {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }
}
