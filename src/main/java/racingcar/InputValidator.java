package racingcar;

import static racingcar.RacingConstants.MIN_ROUNDS;
import static racingcar.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.ViewConstants.LESS_THAN_MIN_ROUNDS_ERROR_MESSAGE;
import static racingcar.ViewConstants.NAME_DELIMITER;
import static racingcar.ViewConstants.TOTAL_ROUNDS_REGEX;
import static racingcar.ViewConstants.NO_DELIMITER_ERROR_MESSAGE;
import static racingcar.ViewConstants.CONTAINS_NON_DIGIT_ERROR_MESSAGE;

import java.util.List;

public class InputValidator {
    public void validateThatDelimiterIsIn(String input) {
        if (!input.contains(NAME_DELIMITER)) {
            throw new IllegalArgumentException(NO_DELIMITER_ERROR_MESSAGE);
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
