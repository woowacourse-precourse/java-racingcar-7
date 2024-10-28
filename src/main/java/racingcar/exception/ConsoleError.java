package racingcar.exception;

enum ConsoleError {

	INVALID_INPUT_VALUE("유효한 입력값이 아닙니다.");

	private final String message;

	ConsoleError(String message) {this.message = message;}

	public String getMessage() {
		return message;
	}
}
