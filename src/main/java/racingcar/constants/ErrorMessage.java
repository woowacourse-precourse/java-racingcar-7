package racingcar.constants;

import static racingcar.constants.RaceSystemConstant.MAX_CAR_NAME_CONDITION;
import static racingcar.constants.RaceSystemConstant.MIN_RACE_TIME_CONDITION;

public class ErrorMessage {
    private static final String CAR_NAME_LENGTH_ERROR_FORMAT = "자동차 이름은 공백이거나 %d자를 초과할 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = String.format(
            CAR_NAME_LENGTH_ERROR_FORMAT, MAX_CAR_NAME_CONDITION
    );

    private static final String RACE_TIME_RANGE_ERROR_FORMAT = "시도 횟수는 %d 이상이어야 합니다.";
    public static final String RACE_TIME_RANGE_ERROR_MESSAGE = String.format(
            RACE_TIME_RANGE_ERROR_FORMAT, MIN_RACE_TIME_CONDITION
    );

    public static final String RACE_TIME_FORMAT_ERROR_MESSAGE = "올바른 시도 횟수를 입력하세요.";
}
