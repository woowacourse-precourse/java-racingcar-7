package racingcar.config.exception.input.name;

import racingcar.config.constant.error.ErrorNameConstant;

public class DelimiterNameException extends IllegalArgumentException{
    public DelimiterNameException() {
        super(ErrorNameConstant.ERROR_DELIMITER_NAME);
    }
}
