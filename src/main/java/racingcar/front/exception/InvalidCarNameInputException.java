package racingcar.front.exception;

import racingcar.front.exception.message.ExceptionMessage;

public class InvalidCarNameInputException extends IllegalArgumentException {
    public InvalidCarNameInputException() {
        super(ExceptionMessage.INVALID_CAR_NAME.getMessage());
    }
}
