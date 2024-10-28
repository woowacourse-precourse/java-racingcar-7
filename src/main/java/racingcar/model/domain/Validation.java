package racingcar.model.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
	private static final String GAP = " ";
	private static final int MIN_CAR_COUNT = 1;
	private static final int MAX_CAR_NAME_LENGTH = 5;

	private static final int MIN_ATTEMPT_NUMBER = 1;

	public static void validateCarNames(String inputCarNames) {
		validateEmpty(inputCarNames);
		validateDelimiter(inputCarNames);
		validateNoSpacesBetweenNames(inputCarNames);

		List<String> carNames = Delimiter.COMMA.splitCarNames(inputCarNames);
		validateSingleCarName(carNames);
		validateCarNameLength(carNames);
		validateDuplicateCarNames(carNames);
	}

	private static void validateEmpty(String inputCarNames) {
		if (inputCarNames == null || inputCarNames.trim().isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAME.getMessage());
		}
	}

	private static void validateDelimiter(String inputCarNames) {
		if (!inputCarNames.contains(Delimiter.COMMA.getDelimiter())) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
		}
	}

	private static void validateNoSpacesBetweenNames(String inputCarNames) {
		if (inputCarNames.contains(GAP)) {
			throw new IllegalArgumentException(ErrorMessage.SPACE_BETWEEN_NAME.getMessage());
		}
	}

	private static void validateSingleCarName(List<String> carNames) {
		if (carNames.size() == MIN_CAR_COUNT) {
			throw new IllegalArgumentException(ErrorMessage.SINGLE_CAR_NAME.getMessage());
		}
	}

	private static void validateCarNameLength(List<String> carNames) {
		carNames.stream()
			.filter(carName -> carName.length() > MAX_CAR_NAME_LENGTH)
			.findAny()
			.ifPresent(carName -> {
				throw new IllegalArgumentException(ErrorMessage.OVER_CAR_NAME_LENGTH.getMessage());
			});
	}

	private static void validateDuplicateCarNames(List<String> carNames) {
		Set<String> uniqueCarNames = new HashSet<>(carNames);
		if (uniqueCarNames.size() != carNames.size()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
		}
	}

	public static void validateAttemptNumber(int attemptNumber) {
		if (attemptNumber < MIN_ATTEMPT_NUMBER) {
			throw new IllegalArgumentException(ErrorMessage.NEGATIVE_ATTEMPT_NUMBER.getMessage());
		}
	}
}