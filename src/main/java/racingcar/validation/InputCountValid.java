package racingcar.validation;

import racingcar.constant.NumberConstant;
import racingcar.exception.input.count.LessCountException;
import racingcar.exception.input.count.MoreCountException;
import racingcar.exception.input.count.TypeMissCountException;

public class InputCountValid {
    public static void validTypeMissCount(String count) {
        if (!count.matches(NumberConstant.NUMBER_REGEX)) {
            throw new TypeMissCountException();
        }
    }

    public static void validLessCount(int count) {
        if (count < NumberConstant.MIN_COUNT) {
            throw new LessCountException();
        }
    }

    public static void validMoreCount(int count) {
        if (count == Integer.MAX_VALUE) {
            throw new MoreCountException();
        }
    }

    public static void validRangeCount(int count) {
        validLessCount(count);
        validMoreCount(count);
    }
}
