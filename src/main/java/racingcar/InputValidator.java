package racingcar;

import static racingcar.ExceptionMessages.*;
import static racingcar.RegexPatterns.*;

import java.util.List;

public class InputValidator {
    private static final Integer MAX_NAME_LENGTH = 5;

    public List<String> isValidCarsName(String carNames) {
        isValidInputFormat(carNames);
        isValidName(carNames);
        return Parser.splitByDelimiter(carNames);
    }

    public Boolean isValidInputFormat(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT);
        }
        return true;
    }

    public Boolean isValidName(String input) {
        List<String> names = Parser.splitByDelimiter(input);
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(CONTAINS_DELIMITER_IN_NAME);
            }
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(NAME_TOO_LONG);
            }
        }
        return true;
    }

    public Integer isValidRound(String input) {
        if (!input.matches(DIGIT_REGEX)) {
            throw new IllegalArgumentException(ONLY_NUMERIC_ATTEMPTS);
        }
        return Parser.toInteger(input);
    }
}
