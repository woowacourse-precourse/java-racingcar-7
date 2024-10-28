package racingcar.domain;

import static racingcar.exception.ErrorMessage.*;

public class AttemptCount {
	private final Integer attemptCount;

	public AttemptCount(int attemptCount) {
		validatePositive(attemptCount);
		this.attemptCount = attemptCount;
	}

	private void validatePositive(Integer attemptCount) {
		if (attemptCount <= 0) {
			throw new IllegalArgumentException(ATTEMPT_COUNT_NOT_POSITIVE.getMessage());
		}
	}

	public Integer getAttemptCount() {
		return attemptCount;
	}
}
