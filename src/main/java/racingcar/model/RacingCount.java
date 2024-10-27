package racingcar.model;

import java.util.Objects;
import racingcar.exception.ErrorMessage;

public class RacingCount {

    private static final int ONE_COUNT = 1;
    private static final int END_TRY_COUNT = 0;
    private static final int MIN_TRY_COUNT = 1;

    private int tryCount;

    private RacingCount(int tryCount) {
        validate(tryCount);
        this.tryCount = tryCount;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    public void deduct() {
        this.tryCount -= ONE_COUNT;
    }

    public boolean isTry() {
        return this.tryCount != END_TRY_COUNT;
    }

    private void validate(int tryCount) {
        if (isTryCount(tryCount)) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_TRY_COUNT.getMessage());
        }
    }

    private boolean isTryCount(int tryCount) {
        return tryCount < MIN_TRY_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCount that = (RacingCount) o;
        return tryCount == that.tryCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tryCount);
    }
}
