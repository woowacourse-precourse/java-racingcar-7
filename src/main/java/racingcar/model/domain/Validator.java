package racingcar.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
	private static final int MAX_CAR_NAME_LENGTH = 5;

	public static void validateCarNames(String inputCarNames) {
		validateInputEmpty(inputCarNames);

		List<String> carNames = Delimiter.COMMA.splitCarNames(inputCarNames);
		validateCarNameLength(carNames);
		validateDuplicateCarNames(carNames);
	}

	private static void validateInputEmpty(String inputCarNames) {
		if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
		}
	}

	private static void validateCarNameLength(List<String> carNames) {
		for (String carName : carNames) {
			if (carName.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException(ErrorMessage.OVER_CAR_NAME_LENGTH.getMessage());
			}
		}
	}

	private static void validateDuplicateCarNames(List<String> carNames) {
		Set<String> uniqueCarNames = new HashSet<>(carNames);
		if (uniqueCarNames.size() != carNames.size()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
		}
	}
}