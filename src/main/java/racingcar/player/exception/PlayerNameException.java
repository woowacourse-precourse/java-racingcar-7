package racingcar.player.exception;

import static racingcar.player.exception.message.PlayerNameExceptionMessage.MAX_LENGTH_EXCEEDED;
import static racingcar.player.exception.message.PlayerNameExceptionMessage.MIN_LENGTH_REQUIRED;

import racingcar.common.exception.RacingCarException;

public class PlayerNameException extends RacingCarException {
    public PlayerNameException(String message){
        super(message);
    }

    public static class NameLengthExceededException extends PlayerNameException {
        public NameLengthExceededException() {
            super(MAX_LENGTH_EXCEEDED);
        }
    }

    public static class NameLengthShortException extends PlayerNameException {
        public NameLengthShortException() {
            super(MIN_LENGTH_REQUIRED);
        }
    }
}
