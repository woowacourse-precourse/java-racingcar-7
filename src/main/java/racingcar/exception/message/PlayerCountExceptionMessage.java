package racingcar.exception.message;

import static racingcar.constant.GameConstants.MAXIMUM_PLAYERS;
import static racingcar.constant.GameConstants.MINIMUM_PLAYERS;

public class PlayerCountExceptionMessage {

    private PlayerCountExceptionMessage() {
    }

    public static final String PlayerCountExceeded =
            String.format("플레이어는 최대 %d명 까지 참여할 수 있습니다", MAXIMUM_PLAYERS);

    public static final String PlayerCountShort =
            String.format("플레이어는 최소 %d명 부터 참여할 수 있습니다", MINIMUM_PLAYERS);

}
