package racingcar.validator;

import static racingcar.exception.InputCountExceptionMessage.BLANK_COUNT;
import static racingcar.exception.InputCountExceptionMessage.IMPOSSIBLE_CONVERT_NUMBER;
import static racingcar.exception.InputCountExceptionMessage.INVALID_INTEGER_SCOPE;
import static racingcar.exception.InputCountExceptionMessage.UNDER_MINIMUM_COUNT;

public class InputCountValidator {
    private static final int MINMUM_TRY_COUNT = 1;

    public void isAboveMinimumTryCount(int tryCount) {
        if (tryCount < MINMUM_TRY_COUNT) {
            throw new IllegalArgumentException(UNDER_MINIMUM_COUNT.toString());
        }
    }

    public void isPossibleConvertNumber(String tryCount) {
        if (!tryCount.matches("^%d")) {
            throw new IllegalArgumentException(IMPOSSIBLE_CONVERT_NUMBER.toString());
        }
    }

    public void isValidScope(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER_SCOPE.toString());
        }
    }

    public void isNotBlankTryCount(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException(BLANK_COUNT.toString());
        }
    }
}
