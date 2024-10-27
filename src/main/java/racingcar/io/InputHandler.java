package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

	private InputHandler() {
	}

	public static InputHandler create() {
		return new InputHandler();
	}

	public String inputCarNames() {
		return Console.readLine();
	}

	public String inputAttemptCount() {
		return Console.readLine();
	}

}
