package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InvalidInputException;

public class InputView {
	public String readConsole() {
		try {
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}