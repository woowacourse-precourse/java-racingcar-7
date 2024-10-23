package racingcar;

import static racingcar.ErrorCode.*;

class InputValidator {

    private final static String COMMAS = ",,";
    public static void validateCarNames(String carNames) {
        if (carNames.contains(COMMAS)) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA.getMessage());
        }
    }
}