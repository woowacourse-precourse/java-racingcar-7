package racingcar.exception.player;

import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountExceeded;
import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountShort;

import racingcar.common.exception.RacingCarException;

public class InvalidPlayerCountException extends RacingCarException {

    public InvalidPlayerCountException(String message) {
        super(message);
    }

    public static class PlayerCountExceededException extends InvalidPlayerCountException {
        public PlayerCountExceededException() {
            super(PlayerCountExceeded);
        }
    }

    public static class PlayerCountShortException extends InvalidPlayerCountException {
        public PlayerCountShortException() {
            super(PlayerCountShort);
        }
    }

}
