package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	private InputView() {
	}

	private static class InputViewHolder {
		private static final InputView INSTANCE = new InputView();
	}

	public static InputView getInstance() {
		return InputViewHolder.INSTANCE;
	}

	public List<String> readCarNames() {
		String input = Console.readLine();
		return splitCarNames(input);
	}

	private List<String> splitCarNames(String input) {
		return Arrays.stream(input.split(","))
			.toList();
	}
}
