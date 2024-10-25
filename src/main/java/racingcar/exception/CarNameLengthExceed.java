package racingcar.exception;

import static racingcar.message.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

public class CarNameLengthExceed extends IllegalArgumentException {
    public CarNameLengthExceed() {
        super(CAR_NAME_LENGTH_EXCEED);
    }
}
