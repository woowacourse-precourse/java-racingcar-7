package racingcar.exception;

import static racingcar.message.ErrorMessage.EMPTY_NULL_STRING;

public class NullEmptyStringException extends IllegalArgumentException {
    public NullEmptyStringException() {
        super(EMPTY_NULL_STRING);
    }
}
