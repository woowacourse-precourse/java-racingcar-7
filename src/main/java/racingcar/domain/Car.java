package racingcar.domain;

import static racingcar.common.Constants.INIT_NUMBER;

public class Car {
	private final String carName;
	private int movementDistance;

	public Car(String carName) {
		this.carName = carName;
		this.movementDistance = INIT_NUMBER;
	}

	public void movement() {
		movementDistance++;
	}

	public String getCarName() {
		return this.carName;
	}

	public int getMovement() {
		return this.movementDistance;
	}

}
