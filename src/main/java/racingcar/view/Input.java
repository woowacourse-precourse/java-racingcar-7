package racingcar.view;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {

	public static List<String> readCarNames(){
		String carNames = Console.readLine();
		String[] split = carNames.split(",");

		return Arrays.stream(split)
			.toList();
	}

	public static int readTurn(){
		String turn = Console.readLine();

		// 숫자 아닌 경웅 예외처리 필요.

		return Integer.parseInt(turn);
	}
}
