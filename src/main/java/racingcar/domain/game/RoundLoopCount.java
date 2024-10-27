package racingcar.domain.game;

import racingcar.domain.game.exception.GameRoundException.MaximumGameRoundExceededException;
import racingcar.domain.game.exception.GameRoundException.MinimumGameRoundRequiredException;
import racingcar.domain.game.policy.GameRoundPolicy;

public class RoundLoopCount {
    private final int value;

    private RoundLoopCount(int roundLoopCount) {
        validateLoopCount(roundLoopCount);
        this.value = roundLoopCount;
    }

    public static RoundLoopCount createRoundLoopCount(int value) {
        return new RoundLoopCount(value);
    }

    private void validateLoopCount(int roundLoopCount) {
        validateMinCount(roundLoopCount);
        validateMaxCount(roundLoopCount);
    }

    private void validateMinCount(int roundLoopCount) {
        if (roundLoopCount < GameRoundPolicy.GAME_MINIMUM_ROUND) {
            throw new MinimumGameRoundRequiredException();
        }
    }

    private void validateMaxCount(int roundLoopCount) {
        if (roundLoopCount > GameRoundPolicy.GAME_MAXIMUM_ROUND) {
            throw new MaximumGameRoundExceededException();
        }
    }
}
