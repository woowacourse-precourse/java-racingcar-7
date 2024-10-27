package racingcar.service.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionMessage;

public class CarException extends BaseException {

    public CarException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
