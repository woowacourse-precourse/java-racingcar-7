package racingcar.exception;

import racingcar.constant.ErrorConstant;

public class LengthNameException extends IllegalArgumentException{
    public LengthNameException() {
        super(ErrorConstant.ERROR_LENGTH_NAME);
    }
}
