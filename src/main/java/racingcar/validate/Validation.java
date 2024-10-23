package racingcar.validate;

import racingcar.model.ErrorType;

public class Validation {

    public void isInvalidInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NULL_ERROR.getMessage());
        }
    }

    public void isInvalidNameLength(String input) {
        if(input.trim().length() > 5) {
            throw new IllegalArgumentException(ErrorType.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

}
