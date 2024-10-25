package racingcar.constant;

public enum ErrorStatus {
	NOT_NUMBER("시도 횟수는 숫자를 입력해야 합니다."),
	INVALID_NUMBER_RANGE("시도 횟수는 1 ~ 9,999까지 가능합니다.");
	private final String message;

	ErrorStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
