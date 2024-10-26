package racingcar.exception.input.name;

import racingcar.constant.error.ErrorNameConstant;

public class DelimiterNameException extends IllegalArgumentException{
    public DelimiterNameException() {
        super(ErrorNameConstant.ERROR_DELIMITER_NAME);
    }
}
