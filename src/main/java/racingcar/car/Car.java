package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;

	private int location;

	private static final int START_LOCATION = 0;

	public Car(String name) {
		validateCarLength(name);
		this.name = name;
		this.location = START_LOCATION;
	}

	private static void validateCarLength(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public void execute() {
		int randomNum = Randoms.pickNumberInRange(0, 9);
		if (randomNum >= 4){
			moveForward();
		}
	}

	private void moveForward() {
		this.location ++;
	}

	public void printResult() {
		System.out.println(name + " : " + "-".repeat(location));
	}

	public int getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}
}
