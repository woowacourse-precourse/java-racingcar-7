package racingcar.validator;

import static racingcar.constant.NumberType.MIN_COUNT;
import static racingcar.exception.ErrorMessage.INVALID_COUNT_RANGE;
import static racingcar.exception.ErrorMessage.NOT_INTEGER;

import racingcar.exception.RaceException;

public final class CountValidator {
    public static void countValidate(String count) {
        try {
            int cnt = Integer.parseInt(count);
            if (cnt < MIN_COUNT.getNumber()) {
                throw new RaceException(INVALID_COUNT_RANGE);
            }
        } catch (NumberFormatException e) {
            throw new RaceException(NOT_INTEGER);
        }
    }
}
