package racingcar;

import java.util.List;

public class InputValidator {

    public void isValid(String carNames, String round) {
        isValidInputFormat(carNames);
        isValidName(carNames);
        isValidRound(round);
    }

    public Boolean isValidInputFormat(String input) {
        if (input.startsWith(RegexPatterns.DELIMITER) || input.endsWith(RegexPatterns.DELIMITER)) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_INPUT_FORMAT);
        }
        return true;
    }

    public Boolean isValidName(String input) {
        List<String> names = Parser.splitByDelimiter(input);
        for (String name : names) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessages.CONTAINS_DELIMITER_IN_NAME);
            }

            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessages.NAME_TOO_LONG);
            }
        }
        return true;
    }

    public Boolean isValidRound(String input) {
        if (!input.matches(RegexPatterns.DIGIT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.ONLY_NUMERIC_ATTEMPTS);
        }
        return true;
    }
}
