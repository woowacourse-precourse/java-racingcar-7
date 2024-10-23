package racingcar.common.exception;

import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_NULL;

import racingcar.common.exception.BusinessException;

public class ShouldNotBeNullException extends BusinessException {
    public ShouldNotBeNullException() {
        super(SHOULD_NOT_BE_NULL);
    }
}
