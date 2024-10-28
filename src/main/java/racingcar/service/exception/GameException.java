package racingcar.service.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionMessage;

public class GameException extends BaseException {

    public GameException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
