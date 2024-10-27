package racingcar.validation;

import static racingcar.constant.ErrorMessage.ATTEMPT_COUNT_CANNOT_BE_NULL_OR_EMPTY;
import static racingcar.constant.ErrorMessage.ATTEMPT_COUNT_IS_NOT_AN_INTEGER;
import static racingcar.constant.ErrorMessage.ATTEMPT_COUNT_IS_NOT_POSITIVE_INTEGER;

public class AttemptCountValidation {
    private final static int MINIMUM_ATTEMPT_COUNT = 1;

    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateIsInteger(input);
        validatePositiveNumber(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_CANNOT_BE_NULL_OR_EMPTY.getMessage());
        }
    }

    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_IS_NOT_AN_INTEGER.getMessage());
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) < MINIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(ATTEMPT_COUNT_IS_NOT_POSITIVE_INTEGER.getMessage());
        }
    }
}
