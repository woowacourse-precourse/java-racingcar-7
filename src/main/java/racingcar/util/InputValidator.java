package racingcar.util;

import racingcar.exception.RacingCountException;
import racingcar.exception.message.Error;

public class InputValidator {

    private static final int MINIMUM_MARGIN = 0;

    public static void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new RacingCountException(Error.EMPTY_VALUE);
        }
    }

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RacingCountException(Error.NOT_NUMERIC);
        }
    }

    public static void validatePositive(int input) {
        if (input <= MINIMUM_MARGIN) {
            throw new RacingCountException(Error.NOT_POSITIVE);
        }
    }
}
