package racingcar.domain;

import racingcar.utils.Validator;

public class Round {
    private final int attemptCount;

    public Round(String attemptCountInput) {
        this.attemptCount = parsePositiveAttemptCount(attemptCountInput);
    }

    private int parsePositiveAttemptCount(String attemptCountInput) {
        int attemptCount = Validator.validateIsPositiveNumber(attemptCountInput);
        return attemptCount;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
