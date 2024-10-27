package racingcar.domain.game.exception.message;

import racingcar.domain.game.policy.GamePlayersPolicy;

public class GamePlayersExceptionMessage {
    public static final String MINIMUM_PLAYERS_REQUIRED = String.format("최소 %d명부터 게임 시작 가능합니다.",
            GamePlayersPolicy.GAME_MINIMUM_PLAYERS);
    public static final String MAXIMUM_PLAYERS_EXCEEDED = String.format("최대 %d명까지 게임 시작 가능합니다.",
            GamePlayersPolicy.GAME_MAXIMUM_PLAYERS);
}
