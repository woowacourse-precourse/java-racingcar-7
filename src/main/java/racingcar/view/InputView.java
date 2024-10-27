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

		return Integer.parseInt(input);
	}

	private void validateBlank(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("[ERROR] 아무것도 입력되지 않았습니다.");
		}
	}
}
