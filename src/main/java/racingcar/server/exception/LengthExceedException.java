package racingcar.server.exception;

import static racingcar.client.error.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

public class LengthExceedException extends BusinessException {
    public LengthExceedException(int minValue) {
        super(String.format(CAR_NAME_LENGTH_EXCEED, minValue));
    }
}
