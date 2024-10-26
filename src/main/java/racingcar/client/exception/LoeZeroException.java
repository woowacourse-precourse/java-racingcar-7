package racingcar.client.exception;

import static racingcar.client.error.ErrorMessage.LOWER_THAN_ONE;

public class LoeZeroException extends InputException {
    public LoeZeroException() {
        super(LOWER_THAN_ONE);
    }
}
