package racingcar.controller;

import static java.lang.Integer.parseInt;
import static racingcar.constant.ExceptionMessage.INPUT_TOO_LONG;
import static racingcar.constant.ExceptionMessage.INVALID_NUMBER_FORMAT;
import static racingcar.constant.ExceptionMessage.NULL_OR_EMPTY_INPUT;

public class NumberParser {
    private static final int MAX_DIGITS_TO_PREVENT_OVERFLOW = 10;

    public Integer parse(String input) {
        validateNull(input);

        String trimmedInput = input.strip();
        validateEmpty(trimmedInput);
        validateOverflow(trimmedInput);

        return parseToInt(trimmedInput);
    }

    private void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.message());
        }
    }

    private void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT.message());
        }
    }

    private void validateOverflow(String input) {
        if (input.length() >= MAX_DIGITS_TO_PREVENT_OVERFLOW) {
            throw new IllegalArgumentException(INPUT_TOO_LONG.message());
        }
    }

    private Integer parseToInt(String input) {
        try {
            return parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.message());
        }
    }
}
