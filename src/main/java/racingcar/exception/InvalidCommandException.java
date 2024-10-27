package racingcar.exception;

import racingcar.common.constant.MessageConstants;

public class InvalidCommandException extends IllegalArgumentException {
    public InvalidCommandException() {
        super(MessageConstants.INVALID_COMMAND_ERROR);
    }
}
