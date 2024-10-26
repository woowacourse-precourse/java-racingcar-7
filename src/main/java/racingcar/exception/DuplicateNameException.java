package racingcar.exception;

import racingcar.constant.ErrorConstant;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException() {
        super(ErrorConstant.ERROR_DUPLICATE_NAME);
    }
}
