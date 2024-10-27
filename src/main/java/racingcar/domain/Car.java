package racingcar.domain;

public class Car {
	private String name;
	private int distance;

	public Car(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public void move(int randomNumber) {
		if (isMovable(randomNumber)) {
			distance += 1;
		}
	}

	public boolean isMovable(int randomNumber) {
		return randomNumber >= 4;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}
}
