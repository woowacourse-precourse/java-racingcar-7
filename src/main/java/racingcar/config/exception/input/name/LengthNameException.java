package racingcar.config.exception.input.name;

import racingcar.config.constant.error.ErrorNameConstant;

public class LengthNameException extends IllegalArgumentException{
    public LengthNameException() {
        super(ErrorNameConstant.ERROR_LENGTH_NAME);
    }
}
