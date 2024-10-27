package racingcar.error;

public enum ErrorMessage {
	INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하여야 합니다."),
	INVALID_RACE_COUNT("이동 시도 횟수는 1 이상, 100 이하의 정수여야 합니다."),
	EMPTY_CAR_NAME("자동차 이름을 입력해 주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
