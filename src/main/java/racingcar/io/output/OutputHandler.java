package racingcar.io.output;

public class OutputHandler {

	private static final String CAR_NAMES_INPUT_COMMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String TRY_COUNT_INPUT_COMMENT = "시도할 횟수는 몇 회인가요?";

	public void showCarNamesInputComment() {
		System.out.println(CAR_NAMES_INPUT_COMMENT);
	}

	public void showTryCountInputComment() {
		System.out.println(TRY_COUNT_INPUT_COMMENT);
	}
}
