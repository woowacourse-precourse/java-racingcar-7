package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static List<String> readCarNames() {
		String carNames = Console.readLine();
		String[] split = carNames.split(",");

		return Arrays.stream(split)
			.toList();
	}

	public static int readTurn() {
		String turn = Console.readLine();

		if (isNumeric(turn) == false) {
			throw new IllegalArgumentException("숫자를 입력해주세요.");
		}

		return Integer.parseInt(turn);
	}

	private static boolean isNumeric(String str) {
		return str.matches("-?\\d+");
	}
}
