package racingcar.application.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.domain.race.constants.RaceCriterion.*;
import static racingcar.infrastructure.exception.ErrorCode.*;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String COMMAS = ",,";
    public void validateCarNames(final String carNames) {
        validateCarNamesNotEmpty(carNames);
        validateNoConsecutiveCommas(carNames);
        validateEndsWithComma(carNames);
        validateDuplicatedCarNames(carNames);
    }

    public void validateRound(final String rounds) {
        validateRoundNotEmpty(rounds);
        validateRoundNumber(rounds);
        validateRoundGreaterThanZero(rounds);
    }

    private void validateCarNamesNotEmpty(String carNames) {
        if (carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY.getMessage());
        }
    }

    private void validateNoConsecutiveCommas(final String carNames) {
        if (carNames.contains(COMMAS)) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA.getMessage());
        }
    }

    private void validateEndsWithComma(final String carNames) {
        if (carNames.endsWith(DELIMITER)) {
            throw new IllegalArgumentException(ENDS_WITH_DELIMITER.getMessage());
        }
    }

    private void validateDuplicatedCarNames(final String carNames) {
        List<String> carNamesList = Stream.of(carNames.split(DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
        if (isDuplicated(carNamesList)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAMES.getMessage());
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

    private void validateRoundGreaterThanZero(String rounds) {
        if (Integer.parseInt(rounds) < ROUND_LOWER_BOUND.getCriterion()) {
            throw new IllegalArgumentException(ROUND_LESS_THAN_ONE.getMessage());
        }
    }

    private boolean isDuplicated(final List<String> input) {
        long distinctCount = input.stream().distinct().count();
        return distinctCount < input.size();
    }
}
