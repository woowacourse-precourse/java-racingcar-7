package racingcar.domain;

public class Turn {
	private final int count;

	public Turn(int count, TurnValidator turnValidator) {
		turnValidator.validateTurn(count);
		this.count = count;
	}

	public int getTurnCount() {
		return count;
	}
}
