package racingcar.exception;

import racingcar.common.exception.RacingCarException;
import racingcar.exception.message.CarNameExceptionMessage;

public class CarNameException extends RacingCarException {
    public CarNameException(String message) {
        super(message);
    }

    public static class NameLengthExceededException extends CarNameException {
        public NameLengthExceededException() {
            super(CarNameExceptionMessage.MAX_LENGTH_EXCEEDED);
        }
    }

    public static class NameLengthShortException extends CarNameException {
        public NameLengthShortException() {
            super(CarNameExceptionMessage.MIN_LENGTH_REQUIRED);
        }
    }
}
