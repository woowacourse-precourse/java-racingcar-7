package racingcar.domain.car;

import racingcar.util.RandomNumberGenerator;

public class RandomMoveStrategy implements MoveStrategy {

	private static final int THRESHOLD = 4;
	private final RandomNumberGenerator randomNumberGenerator;

	public RandomMoveStrategy() {
		this.randomNumberGenerator = new RandomNumberGenerator();
	}

	@Override
	public boolean isMovable() {
		return randomNumberGenerator.pick() >= THRESHOLD;
	}
}