package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public record Name(
        String carName
) {
    private static final int MAX_NAME_LENGTH = 5;

    static Name newInstance(String carName) {
        validateCarNameNotEmpty(carName);
        validateCarNameLength(carName);
        return new Name(carName);
    }

    private static void validateCarNameNotEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw RacingCarGameException.from(ErrorMessage.EMPTY_CAR_NAME_ERROR);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw RacingCarGameException.from(ErrorMessage.NAME_TOO_LONG);
        }
    }
}