package racingcar.view.exception;

import static racingcar.common.message.ErrorMessage.LOWER_THAN_ONE;

import racingcar.common.exception.InputException;

public class LoeZeroException extends InputException {
    public LoeZeroException() {
        super(LOWER_THAN_ONE);
    }
}
