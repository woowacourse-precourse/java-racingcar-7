package racingcar.game.exception;

import static racingcar.game.policy.GameRoundPolicy.GAME_MAXIMUM_ROUND;
import static racingcar.game.policy.GameRoundPolicy.GAME_MINIMUM_ROUND;

import racingcar.common.exception.RacingCarException;

public class GameRoundException extends RacingCarException {
    public GameRoundException(String message) {
        super(message);
    }

    public static class MinimumGameRoundRequiredException extends GameRoundException{
        public MinimumGameRoundRequiredException() {
            super(String.format("최소 %d번부터 게임 시작 가능합니다", GAME_MINIMUM_ROUND));
        }
    }

    public static class MaximumGameRoundExceededException extends GameRoundException{
        public MaximumGameRoundExceededException() {
            super(String.format("최대 %d번까지 게임 시작 가능합니다", GAME_MAXIMUM_ROUND));
        }
    }
}
