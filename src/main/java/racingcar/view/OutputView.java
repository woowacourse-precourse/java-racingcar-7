package racingcar.view;

import java.util.List;

import racingcar.model.domain.Car;
import racingcar.model.domain.Delimiter;

public class OutputView {

	private static final String SEMI_COLON = " : ";
	private static final String HYPHEN = "-";

	public static void carName() {
		System.out.println(OutputMessage.INPUT_CAR_NAME.getMessage());
	}

	public static void attemptNumber() {
		System.out.println(OutputMessage.INPUT_ATTEMPT_NUMBER.getMessage());
	}

	public static void runResultGuide() {
		System.out.println(OutputMessage.RACE_RESULT.getMessage());
	}

	public static void runResult(List<Car> cars) {
		cars
			.forEach(car -> System.out.println(car.getName() + SEMI_COLON + HYPHEN.repeat(car.getPosition())));
		System.out.println();
	}

	public static void winners(List<String> winners) {
		System.out.println(OutputMessage.FINAL_WINNER.getMessage() + String.join(Delimiter.COMMA.getDelimiter() + " ", winners));
	}
}