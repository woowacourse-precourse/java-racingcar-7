package racingcar;

import static racingcar.ViewConstants.NO_COMPETITOR_ERROR_MESSAGE;

public class InputValidator {
    public void validateCompetitor(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(NO_COMPETITOR_ERROR_MESSAGE);
        }
    }
}
