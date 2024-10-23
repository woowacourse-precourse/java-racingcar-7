package racingcar.view;

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

		// input을 쉼표를 기준으로 구분한 후 반환한다.
		return List.of();
	}
}
