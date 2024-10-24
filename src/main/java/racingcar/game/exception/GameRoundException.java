package racingcar.game.exception;

import static racingcar.game.exception.message.GameRoundExceptionMessage.*;
import static racingcar.game.policy.GameRoundPolicy.GAME_MAXIMUM_ROUND;
import static racingcar.game.policy.GameRoundPolicy.GAME_MINIMUM_ROUND;

import racingcar.common.exception.RacingCarException;
import racingcar.game.exception.message.GameRoundExceptionMessage;

public class GameRoundException extends RacingCarException {
    public GameRoundException(String message) {
        super(message);
    }

    public static class MinimumGameRoundRequiredException extends GameRoundException{
        public MinimumGameRoundRequiredException() {super(MINIMUM_ROUND_REQUIRED);}
    }

    public static class MaximumGameRoundExceededException extends GameRoundException{
        public MaximumGameRoundExceededException() {super(MAXIMUM_ROUND_EXCEEDED);}
    }
}
