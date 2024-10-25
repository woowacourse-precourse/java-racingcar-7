package racingcar.model;

public class Car {

	private final CarName name;
	private final Movement movement;

	public Car(String name) {
		this.name = new CarName(name);
		this.movement = new Movement();
	}

	public void move(int number) {
		movement.move(number);
	}
}
