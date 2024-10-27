package racingcar.util;

import racingcar.domain.CarName;

import java.util.Arrays;
import java.util.List;

public class CarNameConverter {

    private CarNameConverter() {
        throw new AssertionError();
    }

    private static final String DELIMITER = ",";

    public static List<CarName> convert(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::strip)
                .map(CarName::new)
                .toList();
    }
}
