package racingcar.util;

import java.util.List;
import racingcar.model.Car;

public class CarsCreator {
    public static List<Car> createCarNameToCar(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }
}
