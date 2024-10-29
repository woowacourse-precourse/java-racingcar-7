package racingcar.app.server.exception;

import static racingcar.app.front.error.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

public class LengthExceedException extends BusinessException {
    public LengthExceedException(int minValue) {
        super(String.format(CAR_NAME_LENGTH_EXCEED, minValue));
    }
}
