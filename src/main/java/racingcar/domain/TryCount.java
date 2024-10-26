package racingcar.domain;

import java.util.Objects;

public class TryCount {
    private static final String IS_NOT_TRY_COUNT = "유효한 시도횟수가 아닙니다.";
    private final static String NOT_VALIDATE_NUMBER = "유효하지 않은 숫자 형식입니다.";
    private int tryCount;

    public TryCount(String inputTryCount) {
        this(convertToInt(inputTryCount));
    }

    public TryCount(int tryCount) {
        validateTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private static void validateTryCount(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        }
    }

    private static int convertToInt(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public void decrease() {
        this.tryCount--;
    }

    public boolean isZero() {
        return this.tryCount == 0;
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
        return Objects.equals(this.tryCount, tryCount.tryCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryCount);
    }
}
