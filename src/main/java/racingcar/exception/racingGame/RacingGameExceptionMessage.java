package racingcar.exception.racingGame;

public enum RacingGameExceptionMessage {
	NOT_NUMBER("숫자가 아닙니다."),
	OUT_OF_BOUND("0보다 큰 숫자만 입력가능합니다.");

	private final String message;

	RacingGameExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
