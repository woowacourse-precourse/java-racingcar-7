package racingcar;

import static racingcar.ErrorCode.*;

class InputValidator {

    private final static String COMMAS = ",,";
    private final static int MINIMUM_ROUND_CRITERION = 1;

    public static void validateCarNames(final String carNames) {
        validateNoConsecutiveCommas(carNames);
    }

    public static void validateRound(final String rounds) {
        validateRoundNotEmpty(rounds);
        validateRoundIsNumber(rounds);
        validateRoundNotLessThanOne(rounds);
    }

    private static void validateRoundNotLessThanOne(String rounds) {
        if (Integer.parseInt(rounds) < MINIMUM_ROUND_CRITERION) {
            throw new IllegalArgumentException(ROUNDS_LESS_THAN_ONE.getMessage());
        }
    }

    private static void validateRoundIsNumber(String rounds) {
        try {
            Integer.parseInt(rounds);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ROUNDS_NOT_NUMBER.getMessage());
        }
    }

    private static void validateRoundNotEmpty(String rounds) {
        if (rounds.isEmpty()) {
            throw new IllegalArgumentException(ROUNDS_EMPTY.getMessage());
        }
    }

    private static void validateNoConsecutiveCommas(final String carNames) {
        if (carNames.contains(COMMAS)) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA.getMessage());
        }
    }
}
