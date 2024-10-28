package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.error.ErrorMessage;

public class CarValidator {

	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MAX_CAR_COUNT = 20;

	public void checkCarNames(ArrayList<String> carNames) {
		for (String name : carNames) {
			if (name.isEmpty()) {
				throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
			}
			if (name.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
			}
		}
	}

	public void checkCarCount(List<String> carNames) {
		if (carNames.size() > MAX_CAR_COUNT) {
			throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_COUNT.getMessage());
		}
	}
}