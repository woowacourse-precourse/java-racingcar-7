package racingcar;

import java.util.List;

public class OutputView {
	private static final String PROMPT_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_FOR_ITERATION_COUNT = "시도 횟수는 몇 회인가요?";
	private static final String RESULT_HEADER = "실행 결과";

	private static final String WINNER_NAME_SEPARATOR = ", ";
	private static final String CAR_POSITION_MARKER = "-";

	public static void promptForCarName() {
		System.out.println(PROMPT_FOR_CAR_NAMES);
	}

	public static void promptForIterationCount() {
		System.out.println(PROMPT_FOR_ITERATION_COUNT);
	}

	public static void printResultTitle() {
		System.out.println();
		System.out.println(RESULT_HEADER);
	}

	public static void printResultData(List<String> carNames, List<Long> carPosition) {
		final String CAR_POSITION_FORMAT = "%s : %s%n";

		for (int i = 0; i < carNames.size(); i++) {
			try {
				int repeatCount = Math.toIntExact(carPosition.get(i));
				System.out.printf(CAR_POSITION_FORMAT, carNames.get(i), CAR_POSITION_MARKER.repeat(repeatCount));
			} catch (ArithmeticException e) {
				throw new IllegalArgumentException(ErrorMessage.EXCEED_INT_RANGE);
			}
		}

		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";

		System.out.printf(WINNER_MESSAGE_FORMAT, String.join(WINNER_NAME_SEPARATOR, winners));
	}
}
