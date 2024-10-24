package racingcar.domain;

public class Car {
	private String name;
	private int moveCount;

	private Car(String name) {
		validateName(name);
		this.name = name;
	}

	public static Car create(String name) {
		return new Car(name);
	}

	private void validateName(String name) {
		if (name.isEmpty() || name.length() > 5) {
			throw new IllegalArgumentException();
		}
	}

	public String getName() {
		return name;
	}
}
