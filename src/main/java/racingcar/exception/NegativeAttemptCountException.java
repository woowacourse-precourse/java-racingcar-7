package racingcar.exception;

import static racingcar.message.ErrorMessage.NEGATIVE_ATTEMPT_COUNT;

public class NegativeAttemptCountException extends IllegalArgumentException{
    public NegativeAttemptCountException() {
        super(NEGATIVE_ATTEMPT_COUNT);
    }
}
