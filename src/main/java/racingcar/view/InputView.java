package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.exception.NoSeparatorException;
import racingcar.constant.Separator;
import racingcar.constant.View;

public class InputView {

	private InputView() {
	}

	private static class InputViewHolder {
		private static final InputView INSTANCE = new InputView();
	}

	public static InputView getInstance() {
		return InputViewHolder.INSTANCE;
	}

	public String readInput() {
		System.out.println(View.CAR_NAME_INPUT.getConstant());
		return Console.readLine();
	}

	private List<String> splitBySeparator(String input) {
		return Arrays.stream(input.split(","))
			.toList();
	}

}
