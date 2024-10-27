package racingcar.validator;

import racingcar.exception.RacingException;
import racingcar.view.ErrorMessage;

public class RawCarNamesValidator {

    public void isEmpty(String rawCarNames) {
        if (rawCarNames == null || rawCarNames.isBlank()) {
            throw RacingException.from(ErrorMessage.NO_INPUT);
        }
    }
}
