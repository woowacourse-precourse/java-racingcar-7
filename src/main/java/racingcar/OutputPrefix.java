package racingcar;

public enum OutputPrefix {
	RACE_RESULT_RESPONSE_PREFIX("실행 결과"),
	DISPLAY_NAME_FORMAT("%s : %s"),
	WINNER_LIST_RESULT_RESPONSE_PREFIX("최종 우승자");

	private final String message;

	OutputPrefix(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
