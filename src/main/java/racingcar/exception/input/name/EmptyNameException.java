package racingcar.exception.input.name;

import racingcar.constant.error.ErrorNameConstant;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException() {
        super(ErrorNameConstant.ERROR_EMPTY_NAME);
    }
}
