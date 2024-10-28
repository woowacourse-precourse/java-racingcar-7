package racingcar.validator;

import racingcar.enums.ErrorMessage;

public class TryCountValidator {

    private TryCountValidator() {
    }

    public static void validateTryCount(String tryCount) {
        validateBlank(tryCount);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    public static void validatePositiveInteger(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
