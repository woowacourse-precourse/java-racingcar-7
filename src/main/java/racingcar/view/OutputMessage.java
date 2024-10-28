package racingcar.view;

public enum OutputMessage {
	INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INSERT_ATTEMPT("시도할 횟수는 몇 회인가요?"),
	RESULT_MESSAGE("실행 결과"),
	WINNER("최종 우승자 : %s"),
	DISTANCE("%s : %s%n");

	private final String message;

	OutputMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}