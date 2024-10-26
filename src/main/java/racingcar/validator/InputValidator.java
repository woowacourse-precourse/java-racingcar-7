package racingcar.validator;

import racingcar.exception.ExceptionMessage;

public class InputValidator {
    public void validateCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAMES.getMessage());
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.INSUFFICIENT_CARS.getMessage());
        }
        if (carNames.trim().startsWith(",") || carNames.trim().endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessage.BOUNDARY_DELIMITER.getMessage());
        }
        String[] splitCarNames = carNames.split(",");
        for (String name : splitCarNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME.getMessage());
            }
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.TOO_LONG_NAME.getMessage());
            }
        }
    }

    public void validateAttemptCount(String count) {
        if (count == null || count.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_ATTEMPT_COUNT.getMessage());
        }

        try {
            int parsedCount = Integer.parseInt(count);

            if (parsedCount < 1) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS_ATTEMPT_COUNT.getMessage());
            }
            // 1000을 초과하는 경우 예외 발생
            if (parsedCount > 1000) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS_ATTEMPT_COUNT.getMessage());
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT.getMessage());
        }
    }
}
