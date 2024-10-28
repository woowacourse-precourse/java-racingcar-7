package racingcar.exception;

import racingcar.exception.errorMessage.ErrorMessage;

public class DuplicateCarNameException extends IllegalArgumentException {
    public DuplicateCarNameException() {
        super(ErrorMessage.DUPLICATED_CAR_NAME.getMessage());
    }
}
