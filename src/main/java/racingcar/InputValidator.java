package racingcar;

import static racingcar.RacingConstants.MIN_NUMBER_OF_ATTEMPTS;
import static racingcar.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.ViewConstants.LESS_THAN_MIN_ATTEMPTS_ERROR_MESSAGE;
import static racingcar.ViewConstants.ATTEMPT_REGEX;
import static racingcar.ViewConstants.NO_COMPETITOR_ERROR_MESSAGE;
import static racingcar.ViewConstants.NUMBER_ONLY_ERROR_MESSAGE;

import java.util.List;

public class InputValidator {
    public void validateCompetitor(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NO_COMPETITOR_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateName(List<String> names) {
        long nonDuplicateNames = names.stream().distinct().count();
        if (names.size() != nonDuplicateNames) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public void checkHasNumberOnly(String input) {
        if (!input.matches(ATTEMPT_REGEX)) {
            throw new IllegalArgumentException(NUMBER_ONLY_ERROR_MESSAGE);
        }
    }

    public void checkIsGreaterThanZero(int number) {
        if (number < MIN_NUMBER_OF_ATTEMPTS) {
            throw new IllegalArgumentException(LESS_THAN_MIN_ATTEMPTS_ERROR_MESSAGE);
        }
    }
}
