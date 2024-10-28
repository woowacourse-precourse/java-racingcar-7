package racingcar.validator;

import static racingcar.validator.RoundErrorMessages.DECIMAL_POINT_ERROR_MESSAGE;
import static racingcar.validator.RoundErrorMessages.NON_NEGATIVE_ERROR_MESSAGE;
import static racingcar.validator.RoundErrorMessages.NON_ZERO_ERROR_MESSAGE;
import static racingcar.validator.RoundErrorMessages.NOT_INTEGER_ERROR_MESSAGE;
import static racingcar.validator.RoundErrorMessages.NULL_OR_EMPTY_ERROR_MESSAGE;

public class RoundValidator {

    public static void notNullOrEmpty(String round) {
        if (round == null || round.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    public static void noDecimalPoint(String round) {
        if (round.contains(".")) {
            throw new IllegalArgumentException(DECIMAL_POINT_ERROR_MESSAGE);
        }
    }

    public static void isInteger(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE, e);
        }
    }

    public static void nonNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NON_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public static void nonZero(int number) {
        if (number == 0) {
            throw new IllegalArgumentException(NON_ZERO_ERROR_MESSAGE);
        }
    }

}
