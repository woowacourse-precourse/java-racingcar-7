package racingcar.utils;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public class TryCountParser {
    private static final int MINIMUM_TRY_COUNT = 1;

    private TryCountParser() {
    }

    public static int parseTryCount(String tryCountInput) {
        try {
            int parsedTryCount = Integer.parseInt(tryCountInput);
            validatePositiveIntegerForTryCount(parsedTryCount);
            return parsedTryCount;
        } catch (NumberFormatException e) {
            throw RacingCarGameException.from(ErrorMessage.TRY_COUNT_INVALID);
        }
    }

    private static void validatePositiveIntegerForTryCount(int tryCount) {
        if (tryCount < MINIMUM_TRY_COUNT) {
            throw RacingCarGameException.from(ErrorMessage.TRY_COUNT_INVALID);
        }
    }
}
