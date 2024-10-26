package racingcar.config.exception.input.name;

import racingcar.config.constant.error.ErrorNameConstant;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException() {
        super(ErrorNameConstant.ERROR_DUPLICATE_NAME);
    }
}
