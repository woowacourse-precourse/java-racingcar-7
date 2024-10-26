package racingcar.util;

import java.util.regex.Pattern;

public class MoveCountValidator {

    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public static void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
        validateNumberRange(input);
    }

    private static void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NUMERIC.message);
        }
    }

    private static void validateRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_INT_RANGE.message);
        }
    }

    private static void validateNumberRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber <= 0) {
            throw new IllegalArgumentException(ErrorMessage.EXCEPTION_NUMBER_RANGE.message);
        }
    }
}
