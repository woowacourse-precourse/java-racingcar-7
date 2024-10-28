package racingcar.utils.validation;

import racingcar.exception.RacingExceptionStatus;

public class AttemptValidation {

    public static void validate(String attempt) {
        if (!attempt.matches("[1-9]\\d*")) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_ATTEMPTS_INTEGER.getMessage());
        }
    }
}
