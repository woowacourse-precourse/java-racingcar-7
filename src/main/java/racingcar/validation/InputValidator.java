package racingcar.validation;

import racingcar.constant.ExceptionMessage;

public class InputValidator {

    public void validateInputIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
        }
    }

    public void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EMPTY);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEED);
        }
    }
}
