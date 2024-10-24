package racingcar.car.exception;

import static racingcar.car.exception.message.CarNameExceptionMessage.MAX_LENGTH_EXCEEDED;
import static racingcar.car.exception.message.CarNameExceptionMessage.MIN_LENGTH_REQUIRED;

import racingcar.common.exception.RacingCarException;

public class CarNameException extends RacingCarException {
    public CarNameException(String message){
        super(message);
    }

    public static class NameLengthExceededException extends CarNameException {
        public NameLengthExceededException() {
            super(MAX_LENGTH_EXCEEDED);
        }
    }

    public static class NameLengthShortException extends CarNameException {
        public NameLengthShortException() {
            super(MIN_LENGTH_REQUIRED);
        }
    }
}
