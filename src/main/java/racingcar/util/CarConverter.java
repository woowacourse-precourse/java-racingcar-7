package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public final class CarConverter {

    private CarConverter() {
    }

    public static List<Car> toCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    public static List<String> toNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

}
