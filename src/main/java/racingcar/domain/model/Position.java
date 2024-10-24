package racingcar.domain.model;

public class Position {
	private int value;

	public Position(int value) {
		this.value = value;
	}

	public void increase() {
		value++;
	}

	public int getValue() {
		return value;
	}
}
