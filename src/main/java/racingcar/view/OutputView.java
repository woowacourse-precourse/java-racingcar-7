package racingcar.view;

import racingcar.OutputPrefix;

public class OutputView {

	public void printMessage(OutputPrefix outputPrefix, String message) {
		System.out.println(outputPrefix.getMessage() + message);
	}
}
