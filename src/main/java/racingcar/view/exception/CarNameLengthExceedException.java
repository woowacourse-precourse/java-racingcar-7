package racingcar.view.exception;

import static racingcar.common.message.ErrorMessage.CAR_NAME_LENGTH_EXCEED;

import racingcar.common.exception.InputException;

public class CarNameLengthExceedException extends InputException {
    public CarNameLengthExceedException(int minValue) {
        super(String.format(CAR_NAME_LENGTH_EXCEED, minValue));
    }
}
