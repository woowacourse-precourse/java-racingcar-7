package racingcar.model.count;

import racingcar.common.ErrorMessage;

public class TryCount {
    private static final int ZERO = 0;
    private final int tryCount;

    public TryCount(final String count) {
        final int tryCount = convertStringToInt(count);
        validate(tryCount);
        this.tryCount = tryCount;
    }

    private void validate(final int input) {
        if (input <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private int convertStringToInt(final String input) {
        try {
            long value = Long.parseLong(input);
            checkOutOfIntegerRange(value);
            return (int) value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void checkOutOfIntegerRange(final long input) {
        if (input > Integer.MAX_VALUE || input < Integer.MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
