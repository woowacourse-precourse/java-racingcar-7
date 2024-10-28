package racingcar.model.domain;

public class AttemptNumber {
	private final int attemptNumber;

	public AttemptNumber(int attemptNumber) {
		Validator.validateAttemptNumber(attemptNumber);
		this.attemptNumber = attemptNumber;
	}

	public int getAttemptNumber() {
		return attemptNumber;
	}
}