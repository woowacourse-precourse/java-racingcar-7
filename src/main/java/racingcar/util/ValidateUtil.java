package racingcar.util;

public class ValidateUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";
    private static final String SPACING_PREFIX = " ";

    public static void validateCar(String input) {
        if (input.isBlank() || input.contains(SPACING_PREFIX) || !input.contains(SPLIT_REGEX_PREFIX) || input.split(SPLIT_REGEX_PREFIX).length == 1)
            throw new IllegalArgumentException("Error in Car name input.");
    }

    public static void validateAttemptCount(String attemptCount) {
        try {
            validateNum(Integer.parseInt(attemptCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error in attemptCount input.");
        }
    }

    public static void validateNum(int attemptCount) {
        if (attemptCount < 1)
            throw new IllegalArgumentException("attemptCount must be positive number.");
    }
}
