package racingcar.exception;

import racingcar.exception.message.Error;
import racingcar.exception.model.RacingException;

public class CarNameException extends RacingException {

    public CarNameException(Error error) {
        super(error);
    }
}
