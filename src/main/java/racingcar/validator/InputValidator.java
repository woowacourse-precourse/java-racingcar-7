package racingcar.validator;

import static racingcar.constant.ExceptionMessage.INVALID_INPUT_EMPTY;

public class InputValidator {

    public void validateEmptyString(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_EMPTY.getValue());
        }
    }
}
