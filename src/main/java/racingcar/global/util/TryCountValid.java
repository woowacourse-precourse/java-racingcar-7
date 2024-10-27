package racingcar.global.util;

import static racingcar.global.util.CarConst.MAX_TRY_COUNT_RANGE;
import static racingcar.global.util.CarConst.MIN_TRY_COUNT_RANGE;

public class TryCountValid {
    public static void validateRange(int tryCount) {
        if (tryCount < MIN_TRY_COUNT_RANGE || tryCount > MAX_TRY_COUNT_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
