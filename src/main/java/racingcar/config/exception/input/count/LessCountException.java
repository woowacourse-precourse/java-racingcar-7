package racingcar.config.exception.input.count;

import racingcar.config.constant.error.ErrorCountConstant;

public class LessCountException extends IllegalArgumentException {
    public LessCountException() {
        super(ErrorCountConstant.ERROR_LESS_COUNT);
    }
}
