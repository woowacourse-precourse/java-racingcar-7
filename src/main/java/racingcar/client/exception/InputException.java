package racingcar.client.exception;

import racingcar.server.exception.BusinessException;

public class InputException extends BusinessException {
    public InputException(final String message) {
        super(message);
    }
}
