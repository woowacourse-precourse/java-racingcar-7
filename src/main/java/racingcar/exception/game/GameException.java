package racingcar.exception.game;


import static racingcar.exception.message.GameExceptionMessages.ALREADY_GAME_ENDED;
import static racingcar.exception.message.GameExceptionMessages.GAME_NOT_INITIALIZED;
import static racingcar.exception.message.GameExceptionMessages.VALID_ROUNDS_REQUIRED;

import racingcar.exception.RacingCarException;

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

    public static class GameNotInitializedException extends GameException {
        public GameNotInitializedException() {
            super(GAME_NOT_INITIALIZED);
        }
    }

}
