package racingcar.car;

import racingcar.random.RandomGenerator;

class Car {
	private static final int NAME_LENGTH_LIMIT = 5;
	private static final int MIN_MOVING_CONDITION = 4;

	private final String name;
	private int position;

	Car(String name) {
		validateNameLength(name);

		this.name = name.trim();
		this.position = 0;
	}

	String getName() {
		return name;
	}

	int getPosition() {
		return position;
	}

	private void validateNameLength(String name) {
		if (name.trim().length() > NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
		}
	}

	void move(RandomGenerator random) {
		if (random.generate() >= MIN_MOVING_CONDITION) {
			position++;
		}

		System.out.println(name + " : " + "-".repeat(position));
	}

	boolean isWinner(Car winner) {
		return this.position == winner.position;
	}
}
