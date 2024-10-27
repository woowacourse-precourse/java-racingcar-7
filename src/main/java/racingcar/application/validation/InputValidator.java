package racingcar.application.validation;

import static racingcar.infrastructure.exception.ErrorCode.*;

public class InputValidator {

    private final static String COMMAS = ",,";
    private final static int MINIMUM_ROUND_CRITERION = 1;

    public void validateCarNames(final String carNames) {
        validateNoConsecutiveCommas(carNames);
    }

    public void validateRound(final String rounds) {
        validateRoundNotEmpty(rounds);
        validateRoundIsNumber(rounds);
        validateRoundNotLessThanOne(rounds);
    }

    private void validateRoundNotEmpty(String rounds) {
        if (rounds.trim().isEmpty()) {
            throw new IllegalArgumentException(ROUND_EMPTY.getMessage());
        }
    }

    private void validateRoundNotLessThanOne(String rounds) {
        if (Integer.parseInt(rounds) < MINIMUM_ROUND_CRITERION) {
            throw new IllegalArgumentException(ROUNDS_LESS_THAN_ONE.getMessage());
        }
    }

    private void validateRoundIsNumber(String rounds) {
        try {
            Integer.parseInt(rounds);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ROUND_NOT_NUMBER.getMessage());
        }
    }

    private void validateNoConsecutiveCommas(final String carNames) {
        if (carNames.contains(COMMAS)) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA.getMessage());
        }
    }
}
