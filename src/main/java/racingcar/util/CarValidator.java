package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.error.ErrorMessage;

public class CarValidator {

	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MAX_CAR_COUNT = 20;

	public void checkCarNames(ArrayList<String> carNames) {
		for (String name : carNames) {
			checkEmptyName(name);
			checkNameLength(name);
		}
	}

	private void checkEmptyName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
		}
	}

	private void checkNameLength(String name) {
		if (name.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME.getMessage());
		}
	}

	public void checkCarCount(List<String> carNames) {
		if (carNames.size() > MAX_CAR_COUNT) {
			throw new IllegalArgumentException(ErrorMessage.EXCEED_CAR_COUNT.getMessage());
		}
	}
}