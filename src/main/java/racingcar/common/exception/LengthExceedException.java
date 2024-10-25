package racingcar.common.exception;

import static racingcar.common.message.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

public class LengthExceedException extends BusinessException {
    public LengthExceedException(int minValue) {
        super(String.format(CAR_NAME_LENGTH_EXCEED, minValue));
    }
}
