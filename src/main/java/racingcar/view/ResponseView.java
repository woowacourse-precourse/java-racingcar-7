package racingcar.view;

import java.text.MessageFormat;
import java.util.List;

import racingcar.domain.Car;

public class ResponseView {
	public static final String RESULT_OUTPUT_MESSAGE = "\n실행 결과\n";
	public static final String WINNERS_MESSAGE_FORMAT = "최종 우승자 : {0}";
	public static final String WINNERS_DELIMITER = ", ";

	private final StringBuilder output;

	public ResponseView() {
		output = new StringBuilder(RESULT_OUTPUT_MESSAGE);
	}

	public void addResult(List<Car> cars) {
		for (Car car : cars) {
			output.append(car.print()).append("\n");
		}
		output.append("\n");
	}

	public void addWinners(List<String> winnerNames) {
		String message = MessageFormat.format(WINNERS_MESSAGE_FORMAT, String.join(WINNERS_DELIMITER, winnerNames));
		output.append(message);
	}

	public void print() {
		System.out.println(output);
	}
}
