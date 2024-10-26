package racingcar.exception.input.name;

import racingcar.constant.error.ErrorNameConstant;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException() {
        super(ErrorNameConstant.ERROR_DUPLICATE_NAME);
    }
}
