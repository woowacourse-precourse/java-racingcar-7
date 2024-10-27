package racingcar.exception.message;

import racingcar.domain.game.GameRoundPolicy;

public class GameRoundExceptionMessage {
    public static final String MINIMUM_ROUND_REQUIRED = String.format("최소 %d번부터 게임 시작 가능합니다",
            GameRoundPolicy.GAME_MINIMUM_ROUND);
    public static final String MAXIMUM_ROUND_EXCEEDED = String.format("최대 %d번까지 게임 시작 가능합니다",
            GameRoundPolicy.GAME_MAXIMUM_ROUND);

}