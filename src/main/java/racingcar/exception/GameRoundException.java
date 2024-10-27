package racingcar.exception;

import racingcar.common.exception.RacingCarException;
import racingcar.exception.message.GameRoundExceptionMessage;

public class GameRoundException extends RacingCarException {
    public GameRoundException(String message) {
        super(message);
    }

    public static class MinimumGameRoundRequiredException extends GameRoundException {
        public MinimumGameRoundRequiredException() {
            super(GameRoundExceptionMessage.MINIMUM_ROUND_REQUIRED);
        }
    }

    public static class MaximumGameRoundExceededException extends GameRoundException {
        public MaximumGameRoundExceededException() {
            super(GameRoundExceptionMessage.MAXIMUM_ROUND_EXCEEDED);
        }
    }
}
