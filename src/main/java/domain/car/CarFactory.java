package domain.car;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private static final String SPLIT_DELIMITER = ",";

    private CarFactory() {
    }

    public static List<Car> createCars(final String carNames) {
        return Arrays.stream(carNames.split(SPLIT_DELIMITER))
                .map(Car::from)
                .toList();
    }
}
