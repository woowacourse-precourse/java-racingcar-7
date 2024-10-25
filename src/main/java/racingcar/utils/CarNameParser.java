package racingcar.utils;

import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.validator.CarNameValidator.validateDuplicate;
import static racingcar.validator.CarNameValidator.validateEndsWithDelimiter;

public class CarNameParser {
    public static final String NAME_DELIMITER = ",";

    public static List<String> parse(String input) {
        validateEndsWithDelimiter(input);

        List<String> carNames = Arrays.stream(input.split(NAME_DELIMITER))
                .peek(CarNameValidator::validateLength)
                .toList();

        validateDuplicate(carNames);

        return carNames;
    }
}
