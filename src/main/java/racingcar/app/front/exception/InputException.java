package racingcar.app.front.exception;

import racingcar.app.server.exception.BusinessException;

public class InputException extends BusinessException {
    public InputException(final String message) {
        super(message);
    }
}
