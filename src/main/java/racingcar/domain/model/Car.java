package racingcar.domain.model;

public class Car {

	private static final int FORWARD_MINIMUM_VALUE = 4;

	private final String name;
	private int position;

	public Car(String name) {
		this.name = name;
		position = 0;
	}

	private boolean shouldMoveForward(int number) {
		return number >= FORWARD_MINIMUM_VALUE;
	}

	public void moveForward(int number) {
		if (shouldMoveForward(number)) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
