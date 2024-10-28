package racingcar.common.exception;

import racingcar.common.constant.MessageConstants;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException() {
        super(MessageConstants.INVALID_CAR_NAME_ERROR);
    }
}
