package racingcar.util.validator;

import static racingcar.util.ExceptionMessage.DO_NOT_OVER_MAX;
import static racingcar.util.ExceptionMessage.MUST_BE_INT;

public class RoundNumberValidator {
    private static final String DIGIT_REGEX = "\\d+";

    public static int parseToInt(String value) {
        validateInput(value);
        int rounds;
        try {
            rounds = Integer.parseInt(value);
            isPositiveRound(rounds);
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DO_NOT_OVER_MAX.format());
        }
    }

    private static boolean isNumeric(String value) {
        return value.matches(DIGIT_REGEX);
    }

    private static void validateInput(String value) {
        if (!isNumeric(value)) {
            throw new IllegalArgumentException(MUST_BE_INT.format());
        }
    }

    private static void isPositiveRound(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException(MUST_BE_INT.format());
        }
    }
}