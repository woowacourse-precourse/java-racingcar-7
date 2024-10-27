package racingcar;

import static racingcar.ViewConstants.DUPLICATE_NAME_ERROR_MESSAGE;
import static racingcar.ViewConstants.NO_COMPETITOR_ERROR_MESSAGE;
import static racingcar.ViewConstants.NUMBER_ONLY_ERROR_MESSAGE;

import java.util.Arrays;

public class InputValidator {
    public void validateCompetitor(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NO_COMPETITOR_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateName(String[] names) {
        long nonDuplicateNames = Arrays.stream(names).distinct().count();
        if (names.length != nonDuplicateNames) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public void checkHasNumberOnly(String input) {
        if (!input.equals("[\\d+]")) {
            throw new IllegalArgumentException(NUMBER_ONLY_ERROR_MESSAGE);
        }
    }
}
