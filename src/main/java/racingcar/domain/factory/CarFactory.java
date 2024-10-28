package racingcar.domain.factory;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarFactory {
    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}

