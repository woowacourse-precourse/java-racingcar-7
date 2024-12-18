package racingcar.validator;

import static racingcar.validator.ErrorMessage.TOTAL_ATTEMPTS_MIN_RANGE_ERROR;
import static racingcar.validator.ErrorMessage.TOTAL_ATTEMPTS_OVERFLOW_ERROR;

public class UserInputProcessorValidator {
    private static final Integer MIN_RANGE = 0;
    private static final Integer MAX_RANGE = Integer.MAX_VALUE;

    public void validateTotalAttemptsRange(Long tempTotalAttempts) {
        validateTotalAttemptsInteger(tempTotalAttempts);
        validateTotalAttemptsNonNegative(tempTotalAttempts);
    }

    private void validateTotalAttemptsInteger(Long tempTotalAttempts) {
        if (tempTotalAttempts > MAX_RANGE) {
            throw new IllegalArgumentException(TOTAL_ATTEMPTS_OVERFLOW_ERROR.getMessage());
        }
    }

    private void validateTotalAttemptsNonNegative(Long tempTotalAttempts) {
        if (tempTotalAttempts < MIN_RANGE) {
            throw new IllegalArgumentException(TOTAL_ATTEMPTS_MIN_RANGE_ERROR.getMessage());
        }
    }
}
