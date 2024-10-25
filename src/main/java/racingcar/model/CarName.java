package racingcar.model;

public class CarName {

	private static final int CAR_NAME_MAX_LENGTH_LIMIT = 5;

	private final String name;

	public CarName(String name) {
		checkNameLength(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private void checkNameLength(String name) {
		if (name.length() > CAR_NAME_MAX_LENGTH_LIMIT) {
			throw new IllegalArgumentException();
		}
	}
}
