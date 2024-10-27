package racingcar.utils;

import racingcar.view.ErrorMessage;

public class TryCountParser {

    public static int parseToInt(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
