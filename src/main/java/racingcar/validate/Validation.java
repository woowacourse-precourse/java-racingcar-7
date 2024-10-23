package racingcar.validate;

import racingcar.model.ErrorType;

public class Validation {

    public void isInvalidInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NULL_ERROR.getMessage());
        }
    }

}
