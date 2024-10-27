package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class ValidatingParser {
	private static final int MAX_CAR_NAME_LENGTH = 5;
	private static final int MIN_CARS_COUNT = 1;
	private static final int MIN_ATTEMPT_COUNT = 0;

	private ValidatingParser() {
	}

	public static ValidatingParser create() {
		return new ValidatingParser();
	}

	public List<String> parseValidatedCarNames(String inputCarNames) {
		List<String> separateCarNames = Arrays.stream(inputCarNames.split(",")).toList();
		validateCarName(separateCarNames);
		return separateCarNames;
	}

	public int validateAttemptCount(String inputAttemptCount) {
		int convertNumber = parseAttemptNumber(inputAttemptCount);
		validatePositiveNumber(convertNumber);
		return convertNumber;
	}

	private void validateCarName(List<String> separateCarNames) {
		if (separateCarNames.size() == MIN_CARS_COUNT) {
			throw new IllegalArgumentException(ValidationError.ERROR_CARS_SIZE_ONE.getMessage());
		}

		separateCarNames.forEach(carName -> {
			validateCarNameOverLength(carName);
			validateEmptyString(carName);
		});
	}

	private void validateCarNameOverLength(String carName) {
		if (carName.length() > MAX_CAR_NAME_LENGTH) {
			throw new IllegalArgumentException(ValidationError.ERROR_CAR_NAME_OVER_LENGTH.getMessage());
		}
	}

	private void validateEmptyString(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException(ValidationError.ERROR_CAR_NAME_EMPTY.getMessage());
		}
	}

	private int parseAttemptNumber(String inputAttemptNumber) {
		int convertNumber;
		try {
			convertNumber = Integer.parseInt(inputAttemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ValidationError.ERROR_ATTEMPT_COUNT_NOT_NUMBER_OR_OVERFLOW.getMessage());
		}
		return convertNumber;
	}

	private void validatePositiveNumber(int convertNumber) {
		if (convertNumber <= MIN_ATTEMPT_COUNT) {
			throw new IllegalArgumentException(ValidationError.ERROR_ATTEMPT_COUNT_NOT_POSITIVE_NUMBER.getMessage());
		}
	}
}
