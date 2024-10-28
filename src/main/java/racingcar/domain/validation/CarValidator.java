package racingcar.domain.validation;

import racingcar.exception.CarNameException;
import racingcar.exception.message.Error;

public class CarValidator {

    private static final int MAXIMUM_LENGTH = 5;

    public void validateMaximumLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new CarNameException(Error.INVALID_LENGTH);
        }
    }
}
