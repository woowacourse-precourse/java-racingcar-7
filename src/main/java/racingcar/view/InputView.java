package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements AutoCloseable {
	public String readLine() {
		return Console.readLine();
	}

	@Override
	public void close() {
		Console.close();
	}
}
