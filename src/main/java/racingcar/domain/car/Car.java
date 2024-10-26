package racingcar.domain.car;

import racingcar.validator.ValidationError;

public class Car {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int TARGET_NUMBER = 4;

	private final String name;
	private int moveDistance;

	private Car(String name) {
		validateCarNameOverLength(name);
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

	private void validateCarNameOverLength(String name) {
		if (name.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ValidationError.ERROR_CAR_NAME_OVER_LENGTH.getMessage());
		}
	}
}
