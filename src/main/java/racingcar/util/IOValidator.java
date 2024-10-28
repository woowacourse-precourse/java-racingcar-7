package racingcar.util;

public class IOValidator {
	private static final String NAMES_SEPARATOR = ",";
	private static final int NATURAL_NUMBER = 1;

	public static void validateContainsSeparator(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("자동차 이름들을 입력해주세요.");
		}

		if (!input.contains(NAMES_SEPARATOR)) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 구분자로 2대 이상 입력해주세요.");
		}
	}

	public static void validateNaturalNumber(String input) {
		int number;

		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도할 횟수는 숫자로 입력해주세요.");
		}

		if (number < NATURAL_NUMBER) {
			throw new IllegalArgumentException("시도할 횟수는 자연수로 입력해주세요.");
		}
	}
}
