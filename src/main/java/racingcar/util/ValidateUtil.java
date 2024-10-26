package racingcar.util;

import racingcar.exception.RaceException;

public class ValidateUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";
    private static final String SPACING_PREFIX = " ";

    public static void validateCar(String input) {
        if (input.isBlank() || input.contains(SPACING_PREFIX) || !input.contains(SPLIT_REGEX_PREFIX))
            throw new IllegalArgumentException(RaceException.WRONG_INPUT.getDescription());
    }

    public static void validateAttemptCount(String attemptCount) {
        try {
            if (Integer.parseInt(attemptCount) < 1)
                throw new IllegalArgumentException(RaceException.WRONG_INPUT.getDescription());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RaceException.WRONG_INPUT.getDescription());
        }

    }
}
