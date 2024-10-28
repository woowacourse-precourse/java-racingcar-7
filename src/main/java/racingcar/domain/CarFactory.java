package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private static final String NAME_DELIMITER = ",";

    public static List<Car> createCarsFromInput(String carNames) {
        return Arrays.stream(carNames.split(NAME_DELIMITER))
                .map(Car::new)
                .toList();
    }
}
