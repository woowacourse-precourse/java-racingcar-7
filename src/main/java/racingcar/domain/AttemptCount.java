package racingcar.domain;

public class AttemptCount {
	private final Integer attemptCount;

	protected AttemptCount(int attemptCount) {
		validatePositive(attemptCount);
		this.attemptCount = attemptCount;
	}

	private void validatePositive(Integer attemptCount) {
		if (attemptCount <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야 합니다.");
		}
	}
}
