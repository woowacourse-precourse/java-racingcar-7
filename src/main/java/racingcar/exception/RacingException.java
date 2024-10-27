package racingcar.exception;

import racingcar.view.ErrorMessage;

public class RacingException extends IllegalArgumentException {
    public RacingException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static RacingException from(ErrorMessage errorMessage) {
        return new RacingException(errorMessage);
    }
}
