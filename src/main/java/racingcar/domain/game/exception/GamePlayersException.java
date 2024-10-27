package racingcar.domain.game.exception;

import racingcar.common.exception.RacingCarException;
import racingcar.domain.game.exception.message.GamePlayersExceptionMessage;

public class GamePlayersException extends RacingCarException {
    public GamePlayersException(String message) {
        super(message);
    }

    public static class MinimumPlayersRequiredException extends GamePlayersException {
        public MinimumPlayersRequiredException() {
            super(GamePlayersExceptionMessage.MINIMUM_PLAYERS_REQUIRED);
        }
    }

    public static class MaximumPlayersExceededException extends GamePlayersException {
        public MaximumPlayersExceededException() {
            super(GamePlayersExceptionMessage.MAXIMUM_PLAYERS_EXCEEDED);
        }
    }

}
