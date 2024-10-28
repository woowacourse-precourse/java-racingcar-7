package racingcar.model;

import racingcar.constant.ErrorMessages;

public class TryCount {
    private final int count;

    public TryCount(String count) {
        validateNumberFormat(count);
        this.count = Integer.parseInt(count);
        validateGreaterThanZero();
    }

    private void validateNumberFormat(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT_FORMAT);
        }
    }

    private void validateGreaterThanZero() {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_TRY_COUNT_MIN);
        }
    }
}
