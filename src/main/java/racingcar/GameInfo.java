package racingcar;

import java.util.List;

public class GameInfo {
	private List<String> carNames;
	private int attemptCount;

	private GameInfo(List<String> carNames, int attemptCount) {
		this.carNames = carNames;
		this.attemptCount = attemptCount;
	}

	public static GameInfo of(List<String> carNames, int attemptCount) {
		return new GameInfo(carNames, attemptCount);
	}

	public List<String> getCarNames() {
		return carNames;
	}

	public int getAttemptCount() {
		return attemptCount;
	}
}
