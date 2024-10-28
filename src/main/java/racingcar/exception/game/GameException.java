package racingcar.exception.game;

import static racingcar.exception.message.GameEndedExceptionMessage.ALREADY_GAME_ENDED;
import static racingcar.exception.message.GameRoundExceptionMessage.VALID_ROUNDS_REQUIRED;

import racingcar.common.exception.RacingCarException;

public class GameException extends RacingCarException {
    public GameException(String message) {
        super(message);
    }

    public static class GameEndedException extends GameException {
        public GameEndedException() {
            super(ALREADY_GAME_ENDED);
        }
    }

    public static class InvalidTotalRoundsException extends GameException {
        public InvalidTotalRoundsException() {
            super(VALID_ROUNDS_REQUIRED);
        }
    }

}
