package racingcar.exception;

import static racingcar.message.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

public class CarNameLengthExceedException extends IllegalArgumentException {
    public CarNameLengthExceedException() {
        super(CAR_NAME_LENGTH_EXCEED);
    }
}
