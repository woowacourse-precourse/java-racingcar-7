package racingcar.common.exception;

import racingcar.common.constant.ExceptionMessage;

public class RaceExecuteException extends BaseException {
    public RaceExecuteException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage);
    }
}
