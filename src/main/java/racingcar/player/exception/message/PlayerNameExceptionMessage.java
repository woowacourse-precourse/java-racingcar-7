package racingcar.player.exception.message;

import racingcar.player.policy.PlayerNamePolicy;

public class PlayerNameExceptionMessage {
    private PlayerNameExceptionMessage() {
    }

    public static final String MAX_LENGTH_EXCEEDED =
            String.format("플레이어 이름은 최대 %d자까지 가능합니다.", PlayerNamePolicy.MAX_LENGTH);

    public static final String MIN_LENGTH_REQUIRED =
            String.format("플레이어 이름은 최소 %d자부터 가능합니다.", PlayerNamePolicy.MIN_LENGTH);

}
