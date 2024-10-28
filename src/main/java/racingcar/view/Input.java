package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	private static final String DELIMITER = ",";

	public static List<String> readCarNames() {
		String carNames = Console.readLine();
		String[] split = carNames.split(DELIMITER);

		if (split.length == 0 || Arrays.stream(split).allMatch(String::isBlank)) {
			throw new IllegalArgumentException("자동차 이름을 하나 이상 입력해주세요.");
		}

		return Arrays.stream(split)
			.toList();
	}

	public static int readTurn() {
		String turn = Console.readLine();

		if (!isNumeric(turn)) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}

		return Integer.parseInt(turn);
	}

	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+");
	}
}
