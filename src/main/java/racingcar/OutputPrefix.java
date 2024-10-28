package racingcar;

public enum OutputPrefix {
	DISPLAY_NAME_FORMAT("%s : %s"),
	DISPLAY_WINNER_FORMAT("최종 우승자 : %s"),
	RACE_RESULT_RESPONSE_PREFIX("실행 결과"),
	WINNER_LIST_RESULT_RESPONSE_PREFIX("최종 우승자");

	private final String message;

	OutputPrefix(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
