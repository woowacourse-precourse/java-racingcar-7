package racingcar.model.race.exception;

import racingcar.common.exception.BusinessException;

public class ShouldNotBeMinusException extends BusinessException {
    public ShouldNotBeMinusException(String message) {
        super(message);
    }
}
