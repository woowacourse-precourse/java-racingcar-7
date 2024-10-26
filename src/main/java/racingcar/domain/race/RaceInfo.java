package racingcar.domain.race;

import java.util.List;

public class RaceInfo {
	private final List<String> carNames;
	private final int attemptCount;

	private RaceInfo(List<String> carNames, int attemptCount) {
		this.carNames = carNames;
		this.attemptCount = attemptCount;
	}

	public static RaceInfo of(List<String> carNames, int attemptCount) {
		return new RaceInfo(carNames, attemptCount);
	}

	public List<String> getCarNames() {
		return carNames;
	}

	public int getAttemptCount() {
		return attemptCount;
	}
}
