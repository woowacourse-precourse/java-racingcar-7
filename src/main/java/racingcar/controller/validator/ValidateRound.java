package racingcar.controller.validator;

import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;
import static racingcar.exception.ErrorBase.ROUNDS_COUNT_INVALID;
import static racingcar.exception.ErrorBase.ROUNDS_MUST_BE_NUMBER;

import org.junit.platform.commons.util.StringUtils;

public class ValidateRound {
    public static final int MAX_ROUNDS = 1000;

    public static int validateRounds(String input) {
        validateBlankInput(input);
        int round = parseRound(input);
        validateRoundRange(round);
        return round;
    }

    private static void validateBlankInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY.getMessage());
        }
    }

    private static int parseRound(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUNDS_MUST_BE_NUMBER.getMessage());
        }
    }

    private static void validateRoundRange(int round) {
        if (round <= 0 || round > MAX_ROUNDS) {
            throw new IllegalArgumentException(ROUNDS_COUNT_INVALID.getMessage());
        }
    }
}
