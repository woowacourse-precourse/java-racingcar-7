package racingcar;

import java.util.List;

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
