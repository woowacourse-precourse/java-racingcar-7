package racingcar.exception.message;

import static racingcar.constant.GameConstants.MAXIMUM_ROUNDS;
import static racingcar.constant.GameConstants.MINIMUM_ROUNDS;

public class GameExceptionMessages {

    public static final String ALREADY_GAME_ENDED = "게임이 이미 종료되었습니다.";
    public static final String VALID_ROUNDS_REQUIRED = String.format("라운드는 %d-%d 사이여야 합니다.",
            MINIMUM_ROUNDS,
            MAXIMUM_ROUNDS
    );
    public static final String GAME_NOT_INITIALIZED = "게임이 초기화되지 않았습니다.";


}
