package racingcar.config.exception.input.name;

import racingcar.config.constant.error.ErrorNameConstant;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException() {
        super(ErrorNameConstant.ERROR_EMPTY_NAME);
    }
}
