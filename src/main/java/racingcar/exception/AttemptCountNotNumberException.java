package racingcar.exception;

import static racingcar.message.ErrorMessage.ATTEMPT_NOT_NUMBER;

public class AttemptCountNotNumberException extends IllegalArgumentException{
    public AttemptCountNotNumberException() {
        super(ATTEMPT_NOT_NUMBER);
    }
}
