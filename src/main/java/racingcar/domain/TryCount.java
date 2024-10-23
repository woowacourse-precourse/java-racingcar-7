package racingcar.domain;

import static racingcar.utils.ErrorMessage.INVALID_COUNT;

import java.util.Objects;

public class TryCount {

    private final Long maxCount;
    private Long count;

    public TryCount(String input) {
        this.maxCount = parseAndValidateInput(input);
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

    private long parseAndValidateInput(String input) {
        long parsedCount = parseInput(input);
        validateParsedCount(parsedCount);
        return parsedCount;
    }

    private long parseInput(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    // 변환된 값이 유효한지 확인하는 메서드
    private void validateParsedCount(long count) {
        if (count < 0) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
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
        TryCount tryCount = (TryCount) o;
        return Objects.equals(maxCount, tryCount.maxCount) && Objects.equals(count, tryCount.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCount, count);
    }
}
