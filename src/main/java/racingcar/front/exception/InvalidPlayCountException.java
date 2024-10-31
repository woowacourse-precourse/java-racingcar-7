package racingcar.front.exception;

import racingcar.front.exception.message.ExceptionMessage;

public class InvalidPlayCountException extends IllegalArgumentException {
    public InvalidPlayCountException() {
        super(ExceptionMessage.INVALID_PLAY_COUNT.getMessage());
    }
}
