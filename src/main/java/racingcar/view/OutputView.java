package racingcar.view;

public class OutputView {

	public void printMessage(OutputPrefix outputPrefix, String message) {
		System.out.println(outputPrefix.getMessage() + message);
	}

	public void printMessage(String message) {
		System.out.println(message);
	}
}
