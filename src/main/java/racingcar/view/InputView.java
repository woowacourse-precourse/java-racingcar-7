package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private InputView() {
	}

	private static class InputViewHolder {
		private static final InputView INPUT_VIEW = new InputView();
	}

	public static InputView getInstance() {
		return InputViewHolder.INPUT_VIEW;
	}

	public String readCarNameInput() {
		String input = Console.readLine();
		validateBlank(input);

		return input;
	}

	public int readAttemptCountInput() {
		String input = Console.readLine();
		validateBlank(input);
		validateDigit(input);

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

	private void validatePositive(String input) {
		if (Integer.parseInt(input) <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 0보다 커야 합니다.");
		}
	}

	private boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}


}
