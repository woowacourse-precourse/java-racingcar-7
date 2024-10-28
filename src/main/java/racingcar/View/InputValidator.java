package racingcar.View;

import static racingcar.View.ViewConstants.TOTAL_ROUNDS_REGEX;
import static racingcar.View.ViewConstants.CONTAINS_NON_DIGIT_ERROR_MESSAGE;

public class InputValidator {
    public void validateThatContainsOnlyDigits(String input) {
        if (!input.matches(TOTAL_ROUNDS_REGEX)) {
            throw new IllegalArgumentException(CONTAINS_NON_DIGIT_ERROR_MESSAGE);
        }
    }
}