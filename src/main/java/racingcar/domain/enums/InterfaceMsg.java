package racingcar.domain.enums;

public enum InterfaceMsg {
	REQUEST_INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) "),
	REQUEST_INPUT_CAR_RACE_TIMES("시도할 횟수는 몇 회인가요? "),
	PRINT_OUT("실행 결과"),
	GAME_RESULT("최종 우승자 : ")
	;

	private String value;
	InterfaceMsg(String value) {
		this.value = value;
	}

	public String getKey() {
		return name();
	}

	public String getValue() {
		return value;
	}
}
