package racingcar.exception;

import racingcar.message.ExceptionMessage;

public class InputExceptionHandler {

    public static void validateCarName(String[] names) {
        for (String carName : names) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
            }
        }
    }

    public static void validateAttemptCount(String attemptCount) {
        if (attemptCount.matches("-?\\d+")) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT.getMessage());
        }
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_EMPTY.getMessage());
        }
    }

    public static void validateCarCount(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_COUNT.getMessage());
        }
    }

    public static void validateCarNameEmpty(String[] names) {
        for (String carName : names) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_EMPTY.getMessage());
            }
        }
    }
}
