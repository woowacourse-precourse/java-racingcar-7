package racingcar.exception.message;

import static racingcar.constant.GameConstants.MAXIMUM_PLAYERS;
import static racingcar.constant.GameConstants.MINIMUM_PLAYERS;

public class PlayerExceptionMessages {
    private PlayerExceptionMessages() {
    }

    public static final String PLAYER_COUNT_EXCEEDED =
            String.format("플레이어는 최대 %d명 까지 참여할 수 있습니다", MAXIMUM_PLAYERS);

    public static final String PLAYER_COUNT_UNDERSTAFFED =
            String.format("플레이어는 최소 %d명 부터 참여할 수 있습니다", MINIMUM_PLAYERS);

    public static final String PLAYER_NOT_FOUND_ID = "존재하지 않는 플레이어 id 입니다 : ";

}
