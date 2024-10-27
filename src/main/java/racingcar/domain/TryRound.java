package racingcar.domain;

public class TryRound {
    private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";

    private final int finalRound;
    private int currentRound;

    public TryRound(String invalidTryCount) {
        validatePositiveNumber(invalidTryCount);
        this.finalRound = Integer.parseInt(invalidTryCount);
        currentRound = 1;
    }

    private void validatePositiveNumber(String invalidTryCount) {
        if (!invalidTryCount.matches(POSITIVE_INTEGER_REGEX)) {
            throw new IllegalArgumentException("양수만 입력해야 합니다.");
        }
    }

    public boolean isNotFinish() {
        return finalRound >= currentRound;
    }

    public void moveToNextRound() {
        currentRound++;
    }
}
