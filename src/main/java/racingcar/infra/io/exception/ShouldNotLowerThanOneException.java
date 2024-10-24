package racingcar.infra.io.exception;

import static racingcar.common.message.ErrorMessage.SHOULD_NOT_BE_LOWER_THAN_ONE;

import racingcar.common.exception.InputException;

public class ShouldNotLowerThanOneException extends InputException {
    public ShouldNotLowerThanOneException() {
        super(SHOULD_NOT_BE_LOWER_THAN_ONE);
    }
}
