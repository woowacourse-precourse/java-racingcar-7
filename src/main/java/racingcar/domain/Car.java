package racingcar.domain;

public class Car {
	private static final int MAX_NAME_LENGTH = 5;
	private final String name;
	private int position = 0;

	public Car(String name, int position) {
		validateName(name);
		this.name = name;
		this.position = position;
	}

	public Car(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if (isInvalidName(name)) {
			throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
		}
	}

	private boolean isInvalidName(String name) {
		return name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

}
