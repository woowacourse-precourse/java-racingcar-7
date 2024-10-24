package racingcar.domain.car;

import racingcar.domain.name.Name;

public class Car {
	private final Name name;
	private int score;

	public Car(Name name) {
		this.name = name;
		this.score = 0;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public Name getName() {
		return name;
	}
}
