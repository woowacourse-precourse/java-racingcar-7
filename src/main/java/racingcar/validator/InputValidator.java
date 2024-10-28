package racingcar.validator;

import racingcar.enums.ErrorMessage;

public class InputValidator {

    public static void validateCarNames(String input) {
        validateBlank(input);
    }

    public static void validateTryCount(String tryCount) {
        validateBlank(tryCount);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

}
