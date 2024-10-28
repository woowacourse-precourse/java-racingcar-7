package racingcar.config;

import static racingcar.config.RacingConstants.MIN_ROUNDS;
import static racingcar.config.RacingConstants.REQUIRED_MIN_PLAYERS;
import static racingcar.View.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.View.ViewConstants.LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE;
import static racingcar.View.ViewConstants.TOTAL_ROUNDS_REGEX;
import static racingcar.View.ViewConstants.NOT_ENOUGH_PLAYERS_ERROR_MESSAGE;
import static racingcar.View.ViewConstants.CONTAINS_NON_DIGIT_ERROR_MESSAGE;

import java.util.List;

public class InputValidator {
    public void validateCountOf(List<String> names) {
        if (names.size() < REQUIRED_MIN_PLAYERS) {
            throw new IllegalArgumentException(NOT_ENOUGH_PLAYERS_ERROR_MESSAGE);
        }
    }

    public void validateNonDuplicate(List<String> names) {
        long totalDistinctNames = names.stream().distinct().count();
        if (names.size() != totalDistinctNames) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public void validateThatContainsOnlyDigits(String input) {
        if (!input.matches(TOTAL_ROUNDS_REGEX)) {
            throw new IllegalArgumentException(CONTAINS_NON_DIGIT_ERROR_MESSAGE);
        }
    }

    public void validateMinRoundsOrOver(int number) {
        if (number < MIN_ROUNDS) {
            throw new IllegalArgumentException(LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE);
        }
    }
}