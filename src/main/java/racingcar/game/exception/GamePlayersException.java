package racingcar.game.exception;

import static racingcar.game.exception.message.GamePlayersExceptionMessage.*;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;

import racingcar.common.exception.RacingCarException;
import racingcar.game.exception.message.GamePlayersExceptionMessage;

public class GamePlayersException extends RacingCarException {
    public GamePlayersException(String message) {
        super(message);
    }

    public static class MinimumPlayersRequiredException extends GamePlayersException {
        public MinimumPlayersRequiredException() {
            super(MINIMUM_PLAYERS_REQUIRED);
        }
    }

    public static class MaximumPlayersExceededException extends GamePlayersException {
        public MaximumPlayersExceededException() {
            super(MAXIMUM_PLAYERS_EXCEEDED);
        }
    }

}
