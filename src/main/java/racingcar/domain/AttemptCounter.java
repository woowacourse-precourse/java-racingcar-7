package racingcar.domain;

import static racingcar.domain.ErrorMessage.ATTEMPT_RANGE;

public class AttemptCounter {
    private final static int MIN = 0;
    private final static int MAX = 100;
    private int attemptNumber;

    public AttemptCounter(int attemptNumber) {
        validateAttemptRange(attemptNumber);
        this.attemptNumber = attemptNumber;
    }

    public boolean isEndAttempt() {
        return attemptNumber <= 0;
    }

    public void decrease() {
        this.attemptNumber--;
    }

    private void validateAttemptRange(int attemptNumber) {
        if (attemptNumber <= MIN || attemptNumber > MAX) {
            throw new IllegalArgumentException(ATTEMPT_RANGE.getMessage());
        }
    }

}
