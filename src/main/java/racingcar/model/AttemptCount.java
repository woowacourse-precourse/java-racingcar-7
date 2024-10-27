package racingcar.model;

import racingcar.validator.AttemptCountValidator;

public class AttemptCount {
    private static final int MIN_ATTEMPT_COUNT = 1;

    private int count;

    private AttemptCount(int count) {
        this.count = count;
    }

    public static AttemptCount from(int count) {
        AttemptCountValidator.validateCountRange(count);
        return new AttemptCount(count);
    }

    public void decrease() {
        AttemptCountValidator.checkRemainingAttempts(count);
        count--;
    }

    public boolean canRace() {
        return count >= MIN_ATTEMPT_COUNT;
    }

    public int getCount() {
        return count;
    }
}
