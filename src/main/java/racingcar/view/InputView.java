package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.exception.NoSeparatorException;
import racingcar.constant.ErrorStatus;
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

	public List<String> readCarInput() {
		System.out.println(View.CAR_NAME_INPUT.getConstant());
		String input = Console.readLine();
		return splitNames(input);
	}

	public Integer readCountInput() {
		System.out.println(View.COUNT_INPUT.getConstant());
		String input = Console.readLine();
		return parseCount(input);
	}

	public Integer parseCount(String input) {
		if (!isNumber(input)) {
			throw new IllegalArgumentException(ErrorStatus.NOT_NUMBER.getMessage());
		}
		try {
			int count = Integer.parseInt(input);
			if (10000 <= count || count < 0)
				throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
			return count;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ErrorStatus.INVALID_NUMBER_RANGE.getMessage());
		}
	}

	private Boolean isNumber(String input) {
		for (char c : input.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public List<String> splitNames(String input) {
		String regex = Arrays.stream(Separator.values())
			.map(Separator::getSeparator)
			.reduce((s1, s2) -> s1 + "|" + s2)
			.orElseThrow(() -> new NoSeparatorException("구분자가 존재하지 않습니다."));

		return Arrays.stream(input.split(regex))
			.peek(s -> {
				if (s.isBlank())
					throw new IllegalArgumentException("잘못된 자동차 이름이 있습니다.");
			})
			.toList();
	}
}
