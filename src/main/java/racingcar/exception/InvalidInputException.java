package racingcar.exception;

public class InvalidInputException {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateInput(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }

    public static void validateCarName(String[] carNames) {
        if (carNames.length == 1) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_AT_LEAST_TWO_CAR.getMessage());
        }

        for (String carName : carNames) {
            if (carName == null || carName.trim().isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_BLANK_IS_NOT_ALLOWED.getMessage());
            }

            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ExceptionMessage.EXCEED_MAX_INPUT_LENGTH.getMessage());
            }
        }
    }

    public static void validateAttemptCount(int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_POSITIVE_INTEGER.getMessage());
        }
    }
}
