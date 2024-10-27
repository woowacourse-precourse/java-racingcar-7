package racingcar.exception;

import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountExceeded;
import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountShort;

import racingcar.common.exception.RacingCarException;

public class InvalidPlayerCountException extends RacingCarException {

    public InvalidPlayerCountException(String message) {
        super(message);
    }

    public static class PlayerCountExceededException extends InvalidCarNameException {
        public PlayerCountExceededException() {
            super(PlayerCountExceeded);
        }
    }

    public static class PlayerCountShortException extends InvalidCarNameException {
        public PlayerCountShortException() {
            super(PlayerCountShort);
        }
    }

}
