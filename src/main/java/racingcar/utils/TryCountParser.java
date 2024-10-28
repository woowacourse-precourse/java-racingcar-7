package racingcar.utils;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public class TryCountParser {
    private TryCountParser() {
    }

    public static int parseTryCount(String tryCountInput) {
        try {
            return Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw RacingCarGameException.from(ErrorMessage.TRY_COUNT_INVALID);
        }
    }
}
