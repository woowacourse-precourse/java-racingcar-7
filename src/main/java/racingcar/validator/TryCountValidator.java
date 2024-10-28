package racingcar.validator;

import static racingcar.error.TryCountErrorMessage.*;


public class TryCountValidator {
    public static int validateTryCount(String inputTryCount) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(inputTryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT.getMessage());
        }

        if (tryCount <= 0) {
            throw new IllegalArgumentException(REQUIRED_TRY_COUNT.getMessage());
        }
        return tryCount;
    }
}
