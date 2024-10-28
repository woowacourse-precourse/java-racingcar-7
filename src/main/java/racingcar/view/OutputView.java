package racingcar.view;

public class OutputView {
	public void lineFeed() {
		System.out.println();
	}

	public void print(OutputMessage message) {
		System.out.println(message.getMessage());
	}

	public void print(OutputMessage message, Object... args) {
		System.out.printf(message.getMessage(), args);
	}
}