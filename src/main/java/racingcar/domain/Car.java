package racingcar.domain;

public class Car {
	private final String name;
	private int distance;

	public Car(String name) {
		validateName(name);

		this.name = name;
		this.distance = 0;
	}

	public void move(int randomNumber) {
		if (isMovable(randomNumber)) {
			distance += 1;
		}
	}

	private boolean isMovable(int randomNumber) {
		return randomNumber >= 4;
	}

	private void validateName(String name) {
		validateNotBlank(name);
		validateLength(name);
		validateAlphabet(name);
	}

	private void validateNotBlank(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 비어있을 수 없습니다.");
		}
	}

	private void validateLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 최대 5자를 넘을 수 없습니다.");
		}
	}

	private void validateAlphabet(String name) {
		if (!name.matches("^[a-zA-Z]+")) {
			throw new IllegalArgumentException("[ERROR] 입력값은 알파벳으로만 구성되어야 합니다.");
		}
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}
}
