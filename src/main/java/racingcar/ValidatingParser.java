package racingcar;

import java.util.Arrays;
import java.util.List;

public class ValidatingParser {

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
		int convertNumber = convertValidateAttemptNumber(inputAttemptCount);
		validateAttemptPositiveNumber(convertNumber);
		return convertNumber;
	}

	private void validateCarName(List<String> separateCarNames) {
		if (separateCarNames.size() == 1) {
			throw new IllegalArgumentException(ValidationError.ERROR_CARS_SIZE_ONE.getMessage());
		}

		separateCarNames.forEach(carName -> {
			validateCarNameOverLength(carName);
			validateEmptyString(carName);
		});
	}

	private void validateCarNameOverLength(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException(ValidationError.ERROR_CAR_NAME_OVER_LENGTH.getMessage());
		}
	}

	private void validateEmptyString(String carName) {
		if (carName.isEmpty()) {
			throw new IllegalArgumentException(ValidationError.ERROR_CAR_NAME_EMPTY.getMessage());
		}
	}

	private int convertValidateAttemptNumber(String inputAttemptNumber) {
		int convertNumber;
		try {
			convertNumber = Integer.parseInt(inputAttemptNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ValidationError.ERROR_ATTEMPT_COUNT_NOT_NUMBER.getMessage());
		}
		return convertNumber;
	}

	private void validateAttemptPositiveNumber(int convertNumber) {
		if (convertNumber <= 0) {
			throw new IllegalArgumentException(ValidationError.ERROR_ATTEMPT_COUNT_NOT_POSITIVE_NUMBER.getMessage());
		}
	}
}
