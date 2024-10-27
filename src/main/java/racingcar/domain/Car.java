package racingcar.domain;

public class Car {
	private final String name;
	private int distance;

	public Car(String name, int distance) {
		validateLength(name);
		validateAlphabet(name);

		this.name = name;
		this.distance = distance;
	}

	public void move(int randomNumber) {
		if (isMovable(randomNumber)) {
			distance += 1;
		}
	}

	private boolean isMovable(int randomNumber) {
		return randomNumber >= 4;
	}

	private void validateLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("[ERROR] 입력값의 길이가 유효하지 않습니다.");
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

	@Override
	public String toString() {
		return name + " : " + "-".repeat(distance);
	}
}
