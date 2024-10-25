package racingcar.domain.racingGame;

import racingcar.domain.car.Car;
import racingcar.domain.name.Name;

public class RacingSnapshot {
	private final Name name;
	private final int score;

	public RacingSnapshot(Car car) {
		this.name = car.getName();
		this.score = car.getScore();
	}

	public String getName() {
		return name.getName();
	}

	public int getScore() {
		return score;
	}
}
