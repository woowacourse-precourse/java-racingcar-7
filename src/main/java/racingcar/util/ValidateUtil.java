package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ValidateUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";
    private static final String SPACING_PREFIX = " ";

    public static void validateCar(final String input) {
        if (input.isBlank() || input.contains(SPACING_PREFIX) || !input.contains(SPLIT_REGEX_PREFIX) || input.split(SPLIT_REGEX_PREFIX).length == 1)
            throw new IllegalArgumentException("Error in Car name input.");
        validateCarNameLength(Arrays.stream(input.split(SPLIT_REGEX_PREFIX)).toList());
    }

    private static void validateCarNameLength(final List<String> carNames) {
        carNames.forEach(car -> {
            if (car.length() >= 5)
                throw new IllegalArgumentException("Car name's length must be equal or less than 5");
        });
    }

    public static void validateAttemptCount(final String attemptCount) {
        try {
            validateNum(Integer.parseInt(attemptCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error in attemptCount input.");
        }
    }

    public static void validateNum(final int attemptCount) {
        if (attemptCount < 1)
            throw new IllegalArgumentException("attemptCount must be positive number.");
    }
}
