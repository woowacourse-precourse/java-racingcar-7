package racingcar.validator;

import racingcar.exception.ErrorMessage;

public class InputValidator {

    public void validateIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }
    }

    public void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.OVER_LENGTH_NAME.getMessage());
        }
    }


}
