package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	public String readCarNameInput() {
		String input = Console.readLine();
		validateBlank(input);

		return input;
	}

	public int readAttemptCountInput() {
		String input = Console.readLine();
		validateBlank(input);

		return Integer.parseInt(input);
	}

	private void validateBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다.");
		}
	}

	private void validateDigit(String input) {
		if (!isDigit(input)) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 정수여야 합니다.");
		}
	}

	private boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
