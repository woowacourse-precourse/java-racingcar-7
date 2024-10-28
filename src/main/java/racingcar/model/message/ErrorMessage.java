package racingcar.model.message;

public enum ErrorMessage {

	INVALID_CAR_NAMES_INPUT("자동차 이름은 중복될 수 없습니다."),
	INVALID_CAR_NAME_LENGTH("자동차 이름의 길이는 1 이상 5 이하여야 합니다."),
	INVALID_TRIAL_COUNT("시도할 횟수 입력이 유효하지 않습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
