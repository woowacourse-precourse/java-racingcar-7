package racingcar.model;

import java.util.Objects;

public class RacingCount {

    private static final int MIN_TRY_COUNT = 1;
    private static final int END_TRY_COUNT = 0;

    private int tryCount;

    private RacingCount(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    public static RacingCount from(int count) {
        return new RacingCount(count);
    }

    public void deduct() {
        this.tryCount -= 1;
    }

    public boolean isPossible() {
        return this.tryCount != 0;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도횟수는 최소 1회 이상이여아 합니다.");
        }
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
