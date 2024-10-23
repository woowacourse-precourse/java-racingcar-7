package racingcar;

import static racingcar.ErrorCode.*;

class InputValidator {

    private final static String COMMAS = ",,";
    private final static int MAX_CAR_NAME_LENGTH_CRITERION = 5;

    public static void validate(final String carNames) {
        validateNoConsecutiveCommas(carNames);
        validateCarNameLength(carNames);
        validateCarNameEmpty(carNames);
    }

    private static void validateCarNameEmpty(final String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private static void validateCarNameLength(final String carNames) {
        if (carNames.length() > MAX_CAR_NAME_LENGTH_CRITERION) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

    private static void validateNoConsecutiveCommas(final String carNames) {
        if (carNames.contains(COMMAS)) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA.getMessage());
        }
    }
}