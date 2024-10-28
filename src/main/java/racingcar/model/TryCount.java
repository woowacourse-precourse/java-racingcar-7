package racingcar.model;

import static racingcar.constants.Constants.MIN_TRY_COUNT;

import racingcar.constants.ErrorMessages;

public class TryCount {
    private final int tryCount;

    public TryCount(String tryCount) {
        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);

    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateTryCount(String tryCount) {
        validateInt(tryCount);
        validateOverZero(Integer.parseInt(tryCount));
    }

    private void validateOverZero(int tryCount) {
        if (tryCount <= MIN_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_RANGE_TRY_COUNT.getMessage());
        }
    }

    private void validateInt(String tryCount) {
        if (!isInt(tryCount)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NOT_NUMBER_TRY_COUNT.getMessage());
        }
    }

    private boolean isInt(String tryCount) {
        return tryCount.chars().allMatch(Character::isDigit);
    }
}
