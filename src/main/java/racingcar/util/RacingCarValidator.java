package racingcar.util;

import static racingcar.constant.RacingCarStatic.MAX_CAR_NAME_LENGTH;
import static racingcar.exception.RacingCarErrorCode.CAR_NAME_CANNOT_OVER_LIMIT;

public class RacingCarValidator {

    public void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_OVER_LIMIT.getErrorMsg());
        }
    }
}
