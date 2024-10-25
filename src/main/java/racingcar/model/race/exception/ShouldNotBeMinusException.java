package racingcar.model.race.exception;

import static racingcar.common.message.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;

import racingcar.common.exception.BusinessException;

public class ShouldNotBeMinusException extends BusinessException {
    public ShouldNotBeMinusException() {
        super(LAP_COUNT_SHOULD_NOT_BE_MINUS);
    }
}
