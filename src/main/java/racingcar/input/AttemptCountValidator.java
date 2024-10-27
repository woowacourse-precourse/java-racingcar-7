package racingcar.input;

import racingcar.error.ErrorCode;

public class AttemptCountValidator {

    private static final int MIN_ATTEMPT_COUNT = 1;

    public static void validate(long count) {
        if (count < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException(
                    ErrorCode.INVALID_ATTEMPT_COUNT.getMessage(MIN_ATTEMPT_COUNT)
            );
        }
    }
}
