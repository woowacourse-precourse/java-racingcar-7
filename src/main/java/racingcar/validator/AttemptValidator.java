package racingcar.validator;

import static racingcar.config.GameErrorMessage.NEGATIVE_ATTEMPT_MESSAGE;
import static racingcar.config.GameErrorMessage.NON_NUMERIC_MESSAGE;

public class AttemptValidator {
    private AttemptValidator() {
        throw new IllegalStateException("Validator Class");
    }

    public static void validateAttempt(String attempt) {
        validateNumericInput(attempt);
        validateNegativeInput(attempt);
    }

    private static void validateNumericInput(String attempt) {
        try {
            Integer.parseInt(attempt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }

    private static void validateNegativeInput(String attempt) {
        int attemptNumber = Integer.parseInt(attempt);
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ATTEMPT_MESSAGE);
        }
    }
}
