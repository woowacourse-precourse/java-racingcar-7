package racingcar.common.exception;

import racingcar.common.constant.ExceptionMessage;

public class BaseException extends IllegalArgumentException {

    private final ExceptionMessage exceptionMessage;

    public BaseException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.getMessage());
        this.exceptionMessage = exceptionMessage;
    }
}
