package racingcar.common.exception;

import racingcar.common.constant.MessageConstants;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super(MessageConstants.INVALID_INPUT_ERROR);
    }
}
