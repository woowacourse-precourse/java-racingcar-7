package racingcar.game.exception.message;

import static racingcar.game.policy.GameRoundPolicy.GAME_MAXIMUM_ROUND;
import static racingcar.game.policy.GameRoundPolicy.GAME_MINIMUM_ROUND;

import racingcar.game.exception.GameRoundException;

public class GameRoundExceptionMessage {
    public static final String MINIMUM_ROUND_REQUIRED = String.format("최소 %d번부터 게임 시작 가능합니다", GAME_MINIMUM_ROUND);
    public static final String MAXIMUM_ROUND_EXCEEDED = String.format("최대 %d번까지 게임 시작 가능합니다", GAME_MAXIMUM_ROUND);

}