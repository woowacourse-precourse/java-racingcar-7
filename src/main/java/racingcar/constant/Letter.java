package racingcar.constant;

public enum Letter {
	REQ_RACING_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	REQ_TRYING_COUNT("시도할 횟수는 몇 회인가요?"),
	ANS_RESULT("실행 결과"),
	ANS_WINNER("최종 우승자"),
	COMMA(","),
	COLON(" : "),
	FORWARD_LINE("-");
	
	private final String letter;
	
	Letter(final String letter) {
		this.letter = letter;
	}
	
	@Override
	public String toString() {
		return letter;
	}
}
