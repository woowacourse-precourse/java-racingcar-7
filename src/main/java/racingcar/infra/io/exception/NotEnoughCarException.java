package racingcar.infra.io.exception;

import static racingcar.common.message.ErrorMessage.NOT_ENOUGH_CAR;

import racingcar.common.exception.InputException;

public class NotEnoughCarException extends InputException {
    public NotEnoughCarException(int minValue) {
        super(String.format(NOT_ENOUGH_CAR, minValue));
    }
}
