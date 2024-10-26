package racingcar.exception.input.count;

import racingcar.constant.error.ErrorCountConstant;

public class LessCountException extends IllegalArgumentException {
    public LessCountException() {
        super(ErrorCountConstant.ERROR_LESS_COUNT);
    }
}
