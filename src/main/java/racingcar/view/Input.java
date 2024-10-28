package racingcar.view;

import static racingcar.common.Message.INPUT_COUNT_MESSAGE;
import static racingcar.common.Message.INPUT_INIT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public static String inputCarsName() {
		System.out.println(INPUT_INIT_MESSAGE);
		return Console.readLine();
	}

	public static int inputCount() {
		System.out.println(INPUT_COUNT_MESSAGE);
		return Integer.parseInt(Console.readLine());
	}
}
