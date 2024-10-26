package racingcar.exception.input.name;

import racingcar.constant.error.ErrorNameConstant;

public class LengthNameException extends IllegalArgumentException{
    public LengthNameException() {
        super(ErrorNameConstant.ERROR_LENGTH_NAME);
    }
}
