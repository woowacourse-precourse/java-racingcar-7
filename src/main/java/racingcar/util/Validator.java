package racingcar.util;

import java.util.ArrayList;

import java.util.List;
import racingcar.error.ErrorMessage;

public class Validator {

	public void checkCarNames(ArrayList<String> carNames) {
		for (String name : carNames) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
			}
			if (name.length() > 5) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
			}
		}
	}

	public void checkCarCount(List<String> carNames) {
		if (carNames.size() > 20) {
			throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_COUNT.getMessage());
		}
	}

	public void checkRaceCount(int raceCount) {
		if (raceCount <= 0 || 100 < raceCount) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_RACE_COUNT.getMessage());
		}
	}

}
