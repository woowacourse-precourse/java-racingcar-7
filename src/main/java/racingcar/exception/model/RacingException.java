package racingcar.exception.model;

import racingcar.exception.message.Error;

public class RacingException extends IllegalArgumentException {

    protected RacingException(Error error) {
        super(error.getMessage());
    }
}
