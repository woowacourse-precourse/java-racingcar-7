package racingcar.exception;

import static racingcar.message.ErrorMessage.NO_CAR_NAME;

public class NoCarNameException extends IllegalArgumentException {
    public NoCarNameException() {
        super(NO_CAR_NAME);
    }
}
