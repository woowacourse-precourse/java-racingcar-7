package racingcar.service.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionMessage;

public class CarNamesException extends BaseException {

    public CarNamesException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
