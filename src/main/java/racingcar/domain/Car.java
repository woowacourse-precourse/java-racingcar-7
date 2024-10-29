package racingcar.domain;

import racingcar.config.RaceConfig;

public class Car {
	private final Name name;
	private int distance;

	public Car(String name) {
		this.name = new Name(name);
		this.distance = RaceConfig.INITIAL_DISTANCE.getNumber();
	}

	public void move(int randomNumber) {
		if (isMovable(randomNumber)) {
			distance += RaceConfig.MOVE_DISTANCE.getNumber();
		}
	}

	private boolean isMovable(int randomNumber) {
		return randomNumber >= RaceConfig.MOVE_CONDITION_NUMBER.getNumber();
	}

	public String getName() {
		return name.getName();
	}

	public int getDistance() {
		return distance;
	}
}
