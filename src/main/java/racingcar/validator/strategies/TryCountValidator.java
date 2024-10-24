package racingcar.validator.strategies;

import racingcar.constants.RacingGameConstants;
import racingcar.view.ErrorMessage;

public class TryCountValidator implements ValidationStrategy {

    @Override
    public void validate(String tryCount) {
        validateNotNullOrEmpty(tryCount);
        validateIsPositiveInteger(tryCount);
    }

    private void validateNotNullOrEmpty(String tryCount) {
        if (isNullOrEmpty(tryCount)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
        }
    }

    private boolean isNullOrEmpty(String tryCount) {
        return tryCount == null || tryCount.trim().isEmpty();
    }

    private void validateIsPositiveInteger(String tryCount) {
        int count = parseTryCount(tryCount);
        checkPositive(count);
    }

    private int parseTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void checkPositive(int count) {
        if (count <= RacingGameConstants.INITIAL_POSITION.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
