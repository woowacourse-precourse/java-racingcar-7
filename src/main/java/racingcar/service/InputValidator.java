package racingcar.service;

import static racingcar.model.ExceptionMessage.EMPTY_STRING;
import static racingcar.model.ExceptionMessage.INVALID_CHARACTER;
import static racingcar.model.ExceptionMessage.INVALID_VALUE;

public class InputValidator {

    private static final String PATTERN = "^[a-zA-Z0-9, ]+$";

    private InputValidator() {
    }

    public static boolean validInputEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING.getMessage());
        }
        return true;
    }

    public static boolean validInputCharacter(String input) {
        if (!input.matches(PATTERN)) {
            throw new IllegalArgumentException(INVALID_CHARACTER.getMessage());
        }
        return true;
    }

    public static boolean validInputRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException(INVALID_VALUE.getMessage());
        }
        return true;
    }
}
