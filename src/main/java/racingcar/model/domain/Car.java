package racingcar.model.domain;

public class Car {
	private final String name;

	public Car(String name) {
		Validator.validateCarNames(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}