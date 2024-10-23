package racingcar.validator.strategies;

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
        checkIfPositive(count);
    }

    private int parseTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void checkIfPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
