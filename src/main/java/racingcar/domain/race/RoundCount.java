package racingcar.domain.race;

import racingcar.exception.ErrorMessage;

public class RoundCount {
    private final int roundCount;

    public RoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public static RoundCount from(String input) {
        validateInputBlank(input);
        validatePositiveNumber(input);
        return new RoundCount(Integer.parseInt(input));
    }

    private static void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_ROUND_COUNT_INPUT.getMessage());
        }
    }

    private static void validatePositiveNumber(String input) {
        try {
            int roundCount = Integer.parseInt(input);
            validateNegativeNumber(roundCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }

    private static void validateNegativeNumber(int roundCount) {
        if (roundCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }

    public int getRoundCount() {
        return roundCount;
    }
}
