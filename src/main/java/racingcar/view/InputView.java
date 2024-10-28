package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.util.Parse;

public class InputView {
	public static String getCarNames() {
		return Console.readLine();
	}

	public static int getAttemptNumber() {
		String attemptNumber = Console.readLine();

		return Parse.parseToInt(attemptNumber);
	}
}