package racingcar.domain.validation;

import org.junit.platform.commons.util.StringUtils;
import racingcar.exception.CarNameException;
import racingcar.exception.message.Error;

public class CarValidator {

    private static final int MAXIMUM_LENGTH = 5;

    public void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new CarNameException(Error.EMPTY_VALUE);
        }
    }

    public void validateMaximumLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new CarNameException(Error.INVALID_LENGTH);
        }
    }

    public void validateWhiteSpace(String name) {
        if (StringUtils.containsWhitespace(name)) {
            throw new CarNameException(Error.CONTAINING_WHITE_SPACE);
        }
    }
}
