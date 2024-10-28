package racingcar.validator;

import static racingcar.validator.ErrorMessage.TOTAL_ATTEMPTS_OVERFLOW_ERROR;

public class UserInputProcessorValidator {
    public void validateTotalAttemptsOverflow(Long tempTotalAttempts) {
        if (tempTotalAttempts > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(TOTAL_ATTEMPTS_OVERFLOW_ERROR.getMessage());
        }
    }
}
