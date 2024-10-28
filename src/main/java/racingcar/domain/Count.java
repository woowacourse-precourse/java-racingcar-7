package racingcar.domain;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public record Count(
        int count
) {
    private static final int MINIMUM_TRY_COUNT = 1;

    public static Count newInstance(int count) {
        validatePositiveIntegerForTryCount(count);
        return new Count(count);
    }

    public Count decrement() {
        return new Count(count - 1);
    }

    public boolean isComplete() {
        return count == 0;
    }

    private static void validatePositiveIntegerForTryCount(int count) {
        if (count < MINIMUM_TRY_COUNT) {
            throw RacingCarGameException.from(ErrorMessage.TRY_COUNT_INVALID);
        }
    }
}
