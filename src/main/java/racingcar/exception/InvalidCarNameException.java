package racingcar.exception;

import racingcar.common.exception.RacingCarException;
import racingcar.exception.message.CarNameExceptionMessage;

public class InvalidCarNameException extends RacingCarException {
    public InvalidCarNameException(String message) {
        super(message);
    }

    public static class NameLengthExceededExceptionInvalid extends InvalidCarNameException {
        public NameLengthExceededExceptionInvalid() {
            super(CarNameExceptionMessage.MAX_LENGTH_EXCEEDED);
        }
    }

    public static class NameLengthShortExceptionInvalid extends InvalidCarNameException {
        public NameLengthShortExceptionInvalid() {
            super(CarNameExceptionMessage.MIN_LENGTH_REQUIRED);
        }
    }
}
