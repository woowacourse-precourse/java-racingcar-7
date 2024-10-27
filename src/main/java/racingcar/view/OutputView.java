package racingcar.view;

public class OutputView {

	private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRIAL_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";
	private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
	private static final String LINE_SEPARATOR = "\n";

	public static void printCarNamesInputMessage() {
		System.out.println(CAR_NAMES_INPUT_MESSAGE);
	}

	public static void printTrialCountInputMessage() {
		System.out.println(TRIAL_COUNT_INPUT_MESSAGE);
	}

	public static void printExecutionResultMessage() {
		System.out.println(LINE_SEPARATOR + EXECUTION_RESULT_MESSAGE);
	}

	public static void printProgressResultMessage(String progressResult) {
		System.out.println(progressResult + LINE_SEPARATOR);
	}

	public static void printWinnerResultMessage(String winnerResult) {
		System.out.println("최종 우승자 : " + winnerResult);
	}
}
