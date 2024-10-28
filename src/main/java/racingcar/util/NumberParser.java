package racingcar.util;

import static racingcar.constant.ErrorMessages.INVALID_NUMBER;

public class NumberParser {

    private NumberParser() {
    }

    public static int parsePositiveInteger(String input) {
        if (!NumberValidator.isPositiveInteger(input)) {
            throw new IllegalArgumentException(INVALID_NUMBER);
        }
        return Integer.parseInt(input);
    }
}
