package racingcar.domain;

import static racingcar.utils.ErrorMessage.INVALID_COUNT;

import java.util.Objects;

public class TryCount {

    private final Long maxCount;
    private Long count;

    public TryCount(String input) {
        long maxCount;

        try {
            maxCount = Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }

        if (maxCount < 0) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }

        this.maxCount = maxCount;
        this.count = 0L;
    }

    public TryCount(Long maxCount) {
        this.maxCount = maxCount;
        this.count = 0L;
    }

    public boolean canTry() {
        if (count < maxCount) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TryCount tryCount = (TryCount) o;
        return Objects.equals(maxCount, tryCount.maxCount) && Objects.equals(count, tryCount.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCount, count);
    }
}
