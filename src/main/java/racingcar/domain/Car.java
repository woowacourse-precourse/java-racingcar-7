package racingcar.domain;

public class Car {

	private final String carName;
	private int movementDistance;

	Car(String carName) {
		this.carName = carName;
		this.movementDistance = 0;
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
