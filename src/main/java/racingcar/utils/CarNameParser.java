package racingcar.utils;

import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.validator.CarNameValidator.validateCarNamesList;
import static racingcar.validator.CarNameValidator.validateInput;

public class CarNameParser {
    public static final String NAME_DELIMITER = ",";

    public static List<String> parse(final String input) {
        validateInput(input);

        List<String> carNames = Arrays.stream(input.split(NAME_DELIMITER))
                .peek(CarNameValidator::validateCarName)
                .toList();

        validateCarNamesList(carNames);

        return carNames;
    }
}
