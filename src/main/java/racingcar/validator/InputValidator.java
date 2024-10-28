package racingcar.validator;

import java.util.List;

public class InputValidator {
	public void validateInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
		}

		if (input.startsWith(",") || input.endsWith(",")) {
			throw new IllegalArgumentException("올바른 형식으로 입력해야 합니다.");
		}

		if (input.contains(",,")) {
			throw new IllegalArgumentException("올바른 형식으로 입력해야 합니다.");
		}
	}

	public void validateCarNames(List<String> names) {
		if (names == null || names.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
		}

		if (names.contains("") || names.contains(null)) {
			throw new IllegalArgumentException("올바른 형식으로 입력해야 합니다.");
		}

		names.forEach(this::validateCarName);
	}

	private void validateCarName(String name) {
		String trimmedName = name.trim();
		if (trimmedName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
		}
		if (trimmedName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}
	}

	public int validateAndParseTrials(String input) {
		try {
			int trials = Integer.parseInt(input);
			if (trials <= 0) {
				throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
			}
			return trials;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
		}
	}
}
