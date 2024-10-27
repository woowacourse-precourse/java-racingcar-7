package racingcar.util.validator;

import java.util.regex.Pattern;
import racingcar.util.ExceptionMessage;

public abstract class Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;

    abstract void validate(String input) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replace(" ", "");
    }

    void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NATURAL_NUMBER.getMessage());
        }
    }

    void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    ExceptionMessage.INVALID_OUT_OF_INPUT_BOUND.getMessage(),
                    exception
            );
        }
    }

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}