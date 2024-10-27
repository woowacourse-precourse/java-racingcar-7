package racingcar.converter;

import static racingcar.message.ErrorMessage.INTEGER_TRY_COUNT_REQUIRED;
import static racingcar.message.ErrorMessage.POSITIVE_TRY_COUNT_REQUIRED;

public class StringToRacingTryCountConverter {

    public int convert(String input) {
        int tryCount = toIntValue(input);

        if (isNotPositiveValue(tryCount)) {
            throw new IllegalArgumentException(POSITIVE_TRY_COUNT_REQUIRED.getMessage());
        }

        return tryCount;
    }

    private int toIntValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_TRY_COUNT_REQUIRED.getMessage());
        }
    }

    private boolean isNotPositiveValue(int count) {
        return !(count > 0);
    }
}
