package racingcar.validator;

import racingcar.exception.ErrorMessage;

public class InputValidator {

    public void validateIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }
    }

    public void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH_NAME.getMessage());
        }
    }

    public void validateAttemptCount(String input) {
        validateIsEmpty(input);
        validateNumeric(input);
        validatePositiveInteger(input);
    }

    private void validateNumeric(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPT_COUNT_FORMAT.getMessage());
        }
    }

    private void validatePositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER.getMessage());
            }
            if (input.contains(".")) { // 소수점이 포함되어 있다면
                throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage()); // 소수 예외 처리
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.OVERFLOW_INTEGER.getMessage());
        }
    }
}
