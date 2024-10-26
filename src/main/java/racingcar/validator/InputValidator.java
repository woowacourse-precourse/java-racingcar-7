package racingcar.validator;

import racingcar.exception.ErrorMessage;

public class InputValidator {

    public void validateIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }
    }
}
