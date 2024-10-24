package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;

	private long location;

	public Car(String name) {
		validateCarLength(name);
		this.name = name;
		this.location = 0;
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
}
