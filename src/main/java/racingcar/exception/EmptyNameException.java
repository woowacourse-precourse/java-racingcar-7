package racingcar.exception;

import racingcar.constant.ErrorConstant;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException() {
        super(ErrorConstant.ERROR_EMPTY_NAME);
    }
}
