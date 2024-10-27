package racingcar.domain;

public class Car {
	String name;
	int distance;

	public Car(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public void move(boolean isMovable) {
		if (isMovable) {
			distance += 1;
		}
	}
}
