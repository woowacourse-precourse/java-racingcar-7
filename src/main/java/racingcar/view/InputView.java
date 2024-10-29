package racingcar.view;

import static racingcar.exception.ErrorMessage.*;

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
			throw new IllegalArgumentException(INPUT_BLANK.getMessage());
		}
	}

	private void validateDigit(String input) {
		if (!isDigit(input)) {
			throw new IllegalArgumentException(ATTEMPT_COUNT_NOT_DIGIT.getMessage());
		}
	}

	private boolean isDigit(String input) {
		return input.chars().allMatch(Character::isDigit);
	}
}
