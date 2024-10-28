package racingcar.exception;

import racingcar.exception.errorMessage.ErrorMessage;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException() {
        super(ErrorMessage.INVALID_ATTEMPT_NUMBER.getMessage());
    }
}
