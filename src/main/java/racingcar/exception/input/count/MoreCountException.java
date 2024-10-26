package racingcar.exception.input.count;

import racingcar.constant.error.ErrorCountConstant;

public class MoreCountException extends IllegalArgumentException{
    public MoreCountException() {
        super(ErrorCountConstant.ERROR_MORE_COUNT);
    }
}
