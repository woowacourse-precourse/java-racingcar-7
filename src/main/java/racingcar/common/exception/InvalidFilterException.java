package racingcar.common.exception;

import racingcar.common.constant.MessageConstants;

public class InvalidFilterException extends IllegalArgumentException{
    public InvalidFilterException() {
        super(MessageConstants.INVALID_FILTER_ERROR);
    }
}
