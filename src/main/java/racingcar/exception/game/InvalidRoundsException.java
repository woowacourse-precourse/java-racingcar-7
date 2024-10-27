package racingcar.exception.game;

import static racingcar.exception.message.GameRoundExceptionMessage.VALID_ROUNDS_REQUIRED;

import racingcar.common.exception.RacingCarException;

public class InvalidRoundsException extends RacingCarException {

    public InvalidRoundsException(String message) {
        super(message);
    }

    public static class InvalidTotalRoundsException extends InvalidRoundsException {
        public InvalidTotalRoundsException() {
            super(VALID_ROUNDS_REQUIRED);
        }
    }

}
