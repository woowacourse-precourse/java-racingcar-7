package racingcar.domain;

import static racingcar.utils.ErrorMessage.INVALID_COUNT;

import java.util.Objects;

public class TryCount {

    private final Integer maxCnt;
    private Integer cnt;

    public TryCount(Integer maxCnt) {
        this.maxCnt = maxCnt;
        this.cnt = 0;
    }

    public static TryCount create(String input) {
        Integer parsedCount = parseInput(input);
        validateParsedCount(parsedCount);

        return new TryCount(parsedCount);
    }

    private static Integer parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    private static void validateParsedCount(Integer count) {
        if (count < 0) {
            throw new IllegalArgumentException(INVALID_COUNT.getMessage());
        }
    }

    public boolean canTry() {
        if (cnt < maxCnt) {
            cnt++;
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
        return Objects.equals(maxCnt, tryCount.maxCnt) && Objects.equals(cnt, tryCount.cnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxCnt, cnt);
    }
}
