package racingcar.domain;

public class RaceCountValidator {
	public Long getRounds(String input) {
		Long validatedInput = validateNumeric(input);
		return validateNegative(validatedInput);
	}

	private Long validateNegative(Long rounds) {
		if (rounds <= 0) {
			throw new IllegalArgumentException("경기횟수는 0보다 커야합니다.");
		}
		return rounds;
	}

	private Long validateNumeric(String input) {
		if (!input.matches("[0-9]+")) {
			throw new IllegalArgumentException("숫자만 입력해주세요.");
		}
		return Long.parseLong(input);
	}
}