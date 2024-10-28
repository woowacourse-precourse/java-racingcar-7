package racingcar;

import static racingcar.ExceptionMessage.*;

public class InputValidator {
    static final int MIN_ROUND_COUNT = 1;

    public static Integer validateRoundCount(String input) {
        Integer count;

        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(INVALID_TYPE_ROUND_COUNT.getMessage()));
        }

        if(count < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(String.format(INVALID_RANGE_ROUND_COUNT.getMessage(), MIN_ROUND_COUNT));
        }

        return count;
    }
}
