package racingcar.domain;

import static racingcar.utils.ErrorMessage.INVALID_COUNT;

import java.util.Objects;

public class TryCount {

    private final Integer maxCount;
    private Integer count;

    public TryCount(String input) {
        this.maxCount = parseAndValidateInput(input);
        this.count = 0;
    }

    public TryCount(Integer maxCount) {
        this.maxCount = maxCount;
        this.count = 0;
    }

    public boolean canTry() {
        if (count < maxCount) {
            count++;
            return true;
        }
        return false;
    }

    private Integer parseAndValidateInput(String input) {
        Integer parsedCount = parseInput(input);
        validateParsedCount(parsedCount);

        return parsedCount;
    }

    private Integer parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private void validateParsedCount(Integer count) {
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
