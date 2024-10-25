package racingcar.util.converter;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class CarConverter {
    private static final String CAR_NAME_SEPARATOR = ",";

    public static List<Car> convert(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .map(Car::new)
                .toList();
    }
}
