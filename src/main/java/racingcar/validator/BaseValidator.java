package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseValidator {

    protected static void validateNotNullOrEmpty(final String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    protected static void validatePattern(final String input, Pattern pattern, String errorMessage) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    protected static void validatePositiveNumber(final int number, String errorMessage) {
        if (number < 1) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
