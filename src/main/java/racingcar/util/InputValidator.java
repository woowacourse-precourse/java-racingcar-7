package racingcar.util;

import racingcar.exception.RacingCountException;
import racingcar.exception.message.Error;

public class InputValidator {

    public static void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new RacingCountException(Error.NOT_NUMERIC);
        }
    }
}
