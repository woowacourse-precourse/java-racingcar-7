package racingcar.exception;

import racingcar.constant.ErrorConstant;

public class DelimiterNameException extends IllegalArgumentException{
    public DelimiterNameException() {
        super(ErrorConstant.ERROR_DELIMITER_NAME);
    }
}
