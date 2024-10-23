package racingcar.car;

public class Car {
	private final String name;

	public Car(String name) {
		this.name = name;
	}

	private static void validateCarLength(String carName) {
		if (carName.length() > 5) {
			throw new RuntimeException();
		}
	}
}
