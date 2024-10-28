package racingcar.util;

public class IOValidator {
	private static final String NAMES_SEPARATOR = ",";

	public static void validateContainsSeparator(String input) {
		if (input == null || input.isBlank()) {
			throw new IllegalArgumentException("자동차 이름들을 입력해주세요.");
		}

		if (!input.contains(NAMES_SEPARATOR)) {
			throw new IllegalArgumentException("자동차 이름은 쉼표(,)를 구분자로 2대 이상 입력해주세요.");
		}
	}
}
