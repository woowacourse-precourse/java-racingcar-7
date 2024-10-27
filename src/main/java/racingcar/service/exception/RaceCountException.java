package racingcar.service.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionMessage;

public class RaceCountException extends BaseException {

    public RaceCountException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
