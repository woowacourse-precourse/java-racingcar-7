package racingcar.app.front.exception;

import static racingcar.app.front.error.ErrorMessage.LOWER_THAN_ONE;

public class LoeZeroException extends InputException {
    public LoeZeroException() {
        super(LOWER_THAN_ONE);
    }
}
