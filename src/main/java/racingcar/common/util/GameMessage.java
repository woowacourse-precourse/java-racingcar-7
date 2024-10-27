package racingcar.common.util;

public enum GameMessage {
	INPUT_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	INPUT_RACE_LAP("시도할 횟수는 몇 회인가요?"),
	RACE_START("\n실행 결과"),
	RACE_RESULT("최종 우승자 : %s");

	private final String message;

	GameMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String formatMessage(Object... args) {
		return String.format(message, args);
	}
}
