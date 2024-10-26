package racingcar.client.exception;

import static racingcar.client.error.ErrorMessage.EMPTY_INPUT;

public class EmptyInputException extends InputException {
    public EmptyInputException() {
        super(EMPTY_INPUT);
    }
}
