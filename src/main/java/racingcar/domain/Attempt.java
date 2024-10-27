package racingcar.domain;

import racingcar.common.exception.ErrorMessages;

public class Attempt {
	private static final int MIN_ATTEMPT_COUNT = 1;
	private static final String INVALID_RANGE_ERROR =
		String.format("시도 횟수는 %d 이상이어야 합니다.", MIN_ATTEMPT_COUNT);

	private int value;

	public Attempt(int value) {
		this.value = value;
	}

	public static Attempt from(String input) {
		validateNotBlank(input);
		int parsedValue = parseToInt(input);
		validateRange(parsedValue);
		return new Attempt(parsedValue);
	}

	private static void validateNotBlank(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.BLANK_NOT_ALLOWE.getMessage());
		}
	}

	private static int parseToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorMessages.MUST_BE_WHOLE_NUMBER.getMessage());
		}
	}

	private static void validateRange(int value) {
		if (value < MIN_ATTEMPT_COUNT) {
			throw new IllegalArgumentException(INVALID_RANGE_ERROR);
		}
	}

}
