package racingcar.model.input;

import static racingcar.model.message.ErrorMessage.INVALID_CAR_NAMES_INPUT;

import java.util.HashSet;
import java.util.List;

public class TextSeparator {

	private static final String DELIMITER = ",";

	public static List<String> separateCarNames(String text) {
		List<String> carNames = List.of(text.split(DELIMITER));
		checkCarNamesDuplicated(carNames);
		return carNames;
	}

	private static void checkCarNamesDuplicated(List<String> carNames) {
		if (new HashSet<>(carNames).size() != carNames.size()) {
			throw new IllegalArgumentException(INVALID_CAR_NAMES_INPUT.getMessage());
		}
	}
}
