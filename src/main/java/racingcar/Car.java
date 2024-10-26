package racingcar;

public class Car {
	private static final int TARGET_NUMBER = 4;

	private final String name;
	private int moveDistance;

	private Car(String name) {
		this.name = name;
		this.moveDistance = 0;
	}

	public static Car from(String name) {
		return new Car(name);
	}

	public String getName() {
		return name;
	}

	public int getMoveDistance() {
		return moveDistance;
	}

	public void move(int randomNumber) {
		if (TARGET_NUMBER <= randomNumber) {
			moveDistance++;
		}
	}
}
