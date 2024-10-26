package racingcar.client.exception;

import static racingcar.client.error.ErrorMessage.NOT_ENOUGH_CAR;

public class NotEnoughCarException extends InputException {
    public NotEnoughCarException(int minValue) {
        super(String.format(NOT_ENOUGH_CAR, minValue));
    }
}
