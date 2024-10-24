package racingcar.validation;

import racingcar.enums.ErrorMessage;

public class TryCountValidator {
    public static void validate(String input) {
        validateNull(input);
        validateTryCountRange(input);
    }

    private static void validateTryCountRange(String input) {
        int tryCount = Integer.parseInt(input);
        if (tryCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.TRY_COUNT_UNDER_ONE.getMessage());
        }
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_TRY_COUNT_BLANK.getMessage());
        }
    }
}
