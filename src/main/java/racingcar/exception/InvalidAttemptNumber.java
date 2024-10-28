package racingcar.exception;

import racingcar.exception.errorMessage.ErrorMessage;

public class InvalidAttemptNumber extends IllegalArgumentException {
    public InvalidAttemptNumber() {
        super(ErrorMessage.INVALID_ATTEMPT_NUMBER.getMessage());
    }
}
