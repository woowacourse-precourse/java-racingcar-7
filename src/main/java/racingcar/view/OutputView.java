package racingcar.view;

import java.util.List;

import racingcar.model.domain.Car;
import racingcar.model.domain.Delimiter;

public class OutputView {

	private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_ATTEMPT_NUMBER = "시도할 횟수는 몇 회인가요?";
	private static final String RACE_RESULT = "\n실행 결과";
	private static final String SEMI_COLON = " : ";
	private static final String HYPHEN = "-";
	private static final String FINAL_WINNER = "최종 우승자 : ";

	public static void carName() {
		System.out.println(INPUT_CAR_NAME);
	}

	public static void attemptNumber() {
		System.out.println(INPUT_ATTEMPT_NUMBER);
	}

	public static void raceResultGuide() {
		System.out.println(RACE_RESULT);
	}

	public static void raceResult(List<Car> cars) {
		cars
			.forEach(car -> System.out.println(car.getName() + SEMI_COLON + HYPHEN.repeat(car.getPosition())));
		System.out.println();
	}

	public static void winners(List<String> winners) {
		System.out.println(FINAL_WINNER + String.join(Delimiter.COMMA.getDelimiter() + " ", winners));
	}
}