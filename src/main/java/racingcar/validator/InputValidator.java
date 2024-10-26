package racingcar.validator;

import racingcar.exception.ExceptionMessage;

public class InputValidator {
    public void validateCarNames(String carNames) {
        checkEmptyCarNames(carNames);
        checkMinimumCarCount(carNames);
        checkBoundary(carNames);
        String[] splitCarNames = carNames.split(",");

        for (String name : splitCarNames) {
            checkCarNameValid(name);
            checkCarNameLength(name);
        }
    }

    public void validateAttemptCount(String count) {
        validateEmptyCount(count);

        try {
            int parsedCount = Integer.parseInt(count);
            checkCountBounds(parsedCount);

        } catch (NumberFormatException e) {
            throw checkCountValid();
        }
    }

    private void checkEmptyCarNames(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private void checkMinimumCarCount(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.INSUFFICIENT_CARS.getMessage());
        }
    }

    private void checkBoundary(String carNames) {
        if (carNames.trim().startsWith(",") || carNames.trim().endsWith(",")) {
            throw new IllegalArgumentException(ExceptionMessage.BOUNDARY_DELIMITER.getMessage());
        }
    }

    private void checkCarNameValid(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    private void checkCarNameLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.TOO_LONG_NAME.getMessage());
        }
    }

    private static void validateEmptyCount(String count) {
        if (count == null || count.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_ATTEMPT_COUNT.getMessage());
        }
    }

    private static void checkCountBounds(int parsedCount) {
        if (parsedCount < 1 || parsedCount > 1000) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS_ATTEMPT_COUNT.getMessage());
        }
    }

    private static IllegalArgumentException checkCountValid() {
        return new IllegalArgumentException(ExceptionMessage.INVALID_ATTEMPT_COUNT.getMessage());
    }
}
