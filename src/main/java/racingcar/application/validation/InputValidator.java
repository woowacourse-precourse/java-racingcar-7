package racingcar.application.validation;

import static racingcar.domain.race.constants.RaceCriterion.*;
import static racingcar.infrastructure.exception.ErrorCode.*;

public class InputValidator {

    private final static String COMMAS = ",,";

    public void validateCarNames(final String carNames) {
        validateNoConsecutiveCommas(carNames);
    }

    public void validateRound(final String rounds) {
        validateRoundNotEmpty(rounds);
        validateRoundNumber(rounds);
        validateRoundGreaterThanZero(rounds);
    }

    private void validateRoundGreaterThanZero(String rounds) {
        if (Integer.parseInt(rounds) < MINIMUM_ROUND.getCriterion()) {
            throw new IllegalArgumentException(ROUND_LESS_THAN_ONE.getMessage());
        }
    }

    private void validateRoundNotEmpty(String rounds) {
        if (rounds.trim().isEmpty()) {
            throw new IllegalArgumentException(ROUND_EMPTY.getMessage());
        }
    }

    private void validateRoundNumber(String rounds) {
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
