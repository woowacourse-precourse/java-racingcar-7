package racingcar.validator;

import static racingcar.View.constant.ErrorMessage.BLANK_VALUE;
import static racingcar.View.constant.ErrorMessage.INVALID_INTEGER;
import static racingcar.View.constant.ErrorMessage.TOO_LONG_VALUE;

import racingcar.global.exception.RacingcarException;

public class InputValidator {
    public String check(String input) {
        checkStringLength(input);
        checkBlank(input);
        return input;
    }

    public void checkPrecondition(String input) {
        if (input.trim().endsWith(",")) {
            throw new RacingcarException(BLANK_VALUE);
        }
    }

    public int checkInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new RacingcarException(INVALID_INTEGER);
        }
    }

    public void checkStringLength(String input) {
        if (input.length() > 5) {
            throw new RacingcarException(TOO_LONG_VALUE);
        }
    }

    public void checkBlank(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new RacingcarException(BLANK_VALUE);
        }
    }
}
