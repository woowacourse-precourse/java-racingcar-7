package racingcar.model;

public class AttemptCount {

    private static final int MINIMUM = 0;
    private final int attemptCount;

    public AttemptCount(int attemptCount) {
        validateAttemptCount(attemptCount);
        this.attemptCount = attemptCount;
    }

    private void validateAttemptCount(int attemptCount) {
        if (isOutOfRange(attemptCount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int attemptCount) {
        return attemptCount <= MINIMUM;
    }
}
