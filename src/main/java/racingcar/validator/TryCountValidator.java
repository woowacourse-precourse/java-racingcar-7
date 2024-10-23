package racingcar.validator;

import racingcar.exception.GameErrorMessage;

public class TryCountValidator {
    public void validateTryCountGreaterZero(final int count) {
        if (count < 1) {
            throw new IllegalArgumentException(GameErrorMessage.TRY_COUNT_LITTLE_ONE.getValue());
        }
    }
}
