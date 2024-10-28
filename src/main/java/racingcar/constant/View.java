package racingcar.constant;

public enum View {
	CAR_NAME_INPUT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	COUNT_INPUT("시도할 횟수는 몇 회인가요?"),
	WINNER_OUTPUT("최종 우승자 : ");

	private final String message;

	View(String constant) {
		this.message = constant;
	}

	public String getMessage() {
		return message;
	}
}
