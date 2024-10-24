package racingcar.game.exception;

import static racingcar.game.policy.GamePlayersPolicy.GAME_MAXIMUM_PLAYERS;
import static racingcar.game.policy.GamePlayersPolicy.GAME_MINIMUM_PLAYERS;

import racingcar.common.exception.RacingCarException;

public class GamePlayersException extends RacingCarException {
    public GamePlayersException(String message) {
        super(message);
    }

    public static class MinimumPlayersRequiredException extends GamePlayersException {
        public MinimumPlayersRequiredException() {
            super(String.format("최소 %d명부터 게임 가능합니다.",GAME_MINIMUM_PLAYERS));
        }
    }

    public static class MaximumPlayersExceededException extends GamePlayersException {
        public MaximumPlayersExceededException() {
            super(String.format("최대 %d명까지 게임 가능합니다.",GAME_MAXIMUM_PLAYERS));
        }
    }

}
