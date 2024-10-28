package racingcar.exception;

import racingcar.exception.message.Error;
import racingcar.exception.model.RacingException;

public class RacingCountException extends RacingException {

    public RacingCountException(Error error) {
        super(error);
    }
}
