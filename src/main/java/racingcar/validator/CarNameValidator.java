package racingcar.validator;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingException;

import java.util.regex.Pattern;

public class CarNameValidator {

    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern CAR_NAME_FORMAT = Pattern.compile("^[a-zA-Z0-9]+$");

    public static void validateCarName(final String name) {
        validateLength(name);
        validateFormat(name);
    }

    private static void validateLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw RacingException.of(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }
    }

    private static void validateFormat(final String name) {
        if (!CAR_NAME_FORMAT.matcher(name)
                .matches()) {
            throw RacingException.of(ErrorMessage.INVALID_CAR_NAME_FORMAT);
        }
    }
}
