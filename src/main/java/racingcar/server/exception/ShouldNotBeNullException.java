package racingcar.server.exception;

import static racingcar.server.error.ErrorMessage.SHOULD_NOT_BE_NULL;

public class ShouldNotBeNullException extends BusinessException {
    public ShouldNotBeNullException() {
        super(SHOULD_NOT_BE_NULL);
    }
}
