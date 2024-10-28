package racingcar.car;

class Car {
	private static final int NAME_LENGTH_LIMIT = 5;

	private final String name;
	private int position;

	Car(String name) {
		validateNameLength(name);

		this.name = name.trim();
		this.position = 0;
	}

	private void validateNameLength(String name) {
		if (name.trim().length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
		}
	}
}
