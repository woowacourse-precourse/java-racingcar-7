package racingcar.app.front.exception;

import static racingcar.app.front.error.ErrorMessage.EMPTY_INPUT;

public class EmptyInputException extends InputException {
    public EmptyInputException() {
        super(EMPTY_INPUT);
    }
}
