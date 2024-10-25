package racingcar.utils;

import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    private static final String NAME_DELIMITER = ",";

    public static List<String> parse(String carNames) {
        return Arrays.stream(carNames.split(NAME_DELIMITER))
                .peek(CarNameValidator::validateLength)
                .toList();
    }
}
