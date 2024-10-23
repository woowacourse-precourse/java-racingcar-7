package racingcar.model.race.exception;

import static racingcar.common.message.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;

public class ShouldNotBeMinusException extends IllegalArgumentException {
    public ShouldNotBeMinusException() {
        super(LAP_COUNT_SHOULD_NOT_BE_MINUS);
    }
}
