package racingcar.exception.player;

import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountExceeded;
import static racingcar.exception.message.PlayerCountExceptionMessage.PlayerCountShort;

import racingcar.common.exception.RacingCarException;

public class PlayerException extends RacingCarException {

    public PlayerException(String message) {
        super(message);
    }

    public static class PlayerExceededException extends PlayerException {
        public PlayerExceededException() {
            super(PlayerCountExceeded);
        }
    }

    public static class PlayerUnderstaffedException extends PlayerException {
        public PlayerUnderstaffedException() {
            super(PlayerCountShort);
        }
    }

}
