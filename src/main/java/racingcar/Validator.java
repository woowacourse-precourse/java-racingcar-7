package racingcar;

import java.util.List;

public class Validator {
	private static final String VALID_NAME_PATTERN = "^(?!_)[a-zA-Z0-9가-힣_]+(?<!_)$";

	public static void validateNumericInput(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
		}
	}

	public static void validatePositiveTryCount(int tryCount) {
		if (tryCount <= 0) {
			throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
		}
	}

	public static void validateCarNames(List<String> carNames) {
		for (String name : carNames) {
			validateCarname(name.trim(), carNames);
		}
	}

	public static void validateCarname(String name, List<String> carNames) {
		validateNoSpaces(name);
		validateLength(name);
		validateNoInvalidCharacters(name);
		validateNoDuplicates(name, carNames);
	}

	private static void validateNoSpaces(String name) {
		if (name.contains(" ")) {
			throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
		}
	}

	private static void validateLength(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
		}
	}

	private static void validateNoInvalidCharacters(String name) {
		if (!name.matches(VALID_NAME_PATTERN)) {
			throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 한글만 포함하고, 언더바(_)는 처음이나 끝에 위치할 수 없습니다.");
		}
	}

	private static void validateNoDuplicates(String name, List<String> carNames) {
	    long count = carNames.stream().filter(name::equals).count();
	    if (count > 1) {
	        throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
	    }
	}
}
