package racingcar.validator;

import racingcar.exception.GameErrorMessage;

public class InputValidator {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;

    public void validateCarNameLength(final String name) {
        if (name == null || name.isBlank() || name.length() > CAR_NAME_LIMIT_LENGTH) {
            throw new IllegalArgumentException(GameErrorMessage.CAR_NAME_EXISTS_AND_LIMIT_ERROR.getValue());
        }
    }

    public void validateTryCountGreaterZero(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException(GameErrorMessage.TRY_COUNT_LITTLE_ONE.getValue());
        }
    }
}
