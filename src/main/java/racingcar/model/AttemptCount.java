package racingcar.model;

public class AttemptCount {

    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 이상의 숫자를 입력해주세요.";
    private static final int MINIMUM = 0;
    private final int attemptCount;

    public AttemptCount(int attemptCount) {
        validateAttemptCount(attemptCount);
        this.attemptCount = attemptCount;
    }

    private void validateAttemptCount(int attemptCount) {
        if (isOutOfRange(attemptCount)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int attemptCount) {
        return attemptCount <= MINIMUM;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
