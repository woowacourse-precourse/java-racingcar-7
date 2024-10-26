package racingcar.app.front.exception;

import static racingcar.app.front.error.ErrorMessage.NOT_ENOUGH_CAR;

public class NotEnoughCarException extends InputException {
    public NotEnoughCarException(int minValue) {
        super(String.format(NOT_ENOUGH_CAR, minValue));
    }
}
