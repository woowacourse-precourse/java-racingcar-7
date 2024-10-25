package racingcar.domain;

public class TryRound {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int tryCount;

    public TryRound(String invalidTryCount) {
        validatePositiveNumber(invalidTryCount);
        this.tryCount = Integer.parseInt(invalidTryCount);
    }

    private void validatePositiveNumber(String invalidTryCount) {
        if (!invalidTryCount.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("양수만 입력해야 합니다.");
        }
    }

    public boolean isNotFinish(int currCount) {
        return tryCount >= currCount;
    }
}
