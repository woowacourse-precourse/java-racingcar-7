package racingcar.exception.message;

import static racingcar.constant.GameConstants.MAXIMUM_ROUNDS;
import static racingcar.constant.GameConstants.MINIMUM_ROUNDS;

public class GameRoundExceptionMessage {
    public static final String VALID_ROUNDS_REQUIRED = String.format("라운드는 %d-%d 사이여야 합니다.", MINIMUM_ROUNDS,
            MAXIMUM_ROUNDS);

}