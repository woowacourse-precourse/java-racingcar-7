package racingcar.domain.car;

import racingcar.domain.name.Name;
import racingcar.util.RandomNumberGenerator;

public class Car {
	private static final int ADD_SCORE_NUMBER = 4;
	private final Name name;
	private int score;

	public Car(Name name) {
		this.name = name;
		this.score = 0;
	}

	public void addScore() {
		this.score += 1;
	}

	public Name getName() {
		return name;
	}

	public void processGame(RandomNumberGenerator randomNumberGenerator) {
		int randomNumber = randomNumberGenerator.generateRandomNumber();
		if (randomNumber >= ADD_SCORE_NUMBER){
			addScore();
		}
	}
}
