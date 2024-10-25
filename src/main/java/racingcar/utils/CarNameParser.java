package racingcar.utils.parser;

import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static final String NAME_DELIMITER = ",";

    public static List<String> parse(String input) {
        CarNameValidator.validateEndsWithDelimiter(input);

        List<String> carNames = Arrays.stream(input.split(NAME_DELIMITER))
                .peek(CarNameValidator::validateLength)
                .toList();

        CarNameValidator.validateDuplicate(carNames);

        return carNames;
    }
}
