package racingcar.validator;

import racingcar.view.ErrorMessage;

public class RawCarNamesValidator {

    public void isEmpty(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NO_INPUT.getMessage());
        }
    }
}
