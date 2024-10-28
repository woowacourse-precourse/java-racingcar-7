package racingcar.exception;

import racingcar.exception.errorMessage.ErrorMessage;

public class NotNumberAttemptException extends IllegalArgumentException {
    public NotNumberAttemptException() {
        super(ErrorMessage.NOT_NUMBER_ATTEMPT.getMessage());
    }
}
