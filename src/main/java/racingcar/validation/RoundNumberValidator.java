package racingcar.validation;

import racingcar.util.Parser;
import static racingcar.util.ExceptionMessage.MUST_BE_INT;

public class RoundNumberValidator {
    private static final String DIGIT_REGEX = "\\d+";

    public static int validateRoundNumber(String value) {
        validateInput(value);
        int rounds = Parser.toInt(value);
        isPositiveRound(rounds);
        return rounds;
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