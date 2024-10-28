package racingcar.common.exception;

import racingcar.common.constant.MessageConstants;

public class NegativeIterationException extends IllegalArgumentException {
    public NegativeIterationException() {
        super(MessageConstants.NEGATIVE_ITERATION_ERROR);
    }
}