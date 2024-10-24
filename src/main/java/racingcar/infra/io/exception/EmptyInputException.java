package racingcar.infra.io.exception;

import static racingcar.common.message.ErrorMessage.EMPTY_INPUT;

import racingcar.common.exception.InputException;

public class EmptyInputException extends InputException {
    public EmptyInputException() {
        super(EMPTY_INPUT);
    }
}
