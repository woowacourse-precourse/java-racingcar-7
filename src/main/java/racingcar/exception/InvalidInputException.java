package racingcar.exception;

import racingcar.constant.MessageConstants;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(MessageConstants.INVALID_INPUT_ERROR);
    }
}
