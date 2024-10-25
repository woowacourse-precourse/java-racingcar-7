package racingcar;

public class OutputHandler {
	private static final String PROMPT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String PROMPT_ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";

	private OutputHandler() {
	}

	public static OutputHandler create() {
		return new OutputHandler();
	}

	public void promptForCarNames() {
		System.out.println(PROMPT_CAR_NAMES);
	}

	public void promptForAttemptCount() {
		System.out.println(PROMPT_ATTEMPT_COUNT);
	}
}
