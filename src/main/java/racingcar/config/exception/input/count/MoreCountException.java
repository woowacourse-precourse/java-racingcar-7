package racingcar.config.exception.input.count;

import racingcar.config.constant.error.ErrorCountConstant;

public class MoreCountException extends IllegalArgumentException{
    public MoreCountException() {
        super(ErrorCountConstant.ERROR_MORE_COUNT);
    }
}
