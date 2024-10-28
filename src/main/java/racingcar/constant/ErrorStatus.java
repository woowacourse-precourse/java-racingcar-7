package racingcar.constant;

public enum ErrorStatus {
	NOT_NUMBER("시도 횟수는 숫자를 입력해야 합니다."),
	NO_SEPARATOR("구분자가 존재하지 않습니다."),
	INVALID_CAR_NAME("잘못된 자동차 이름이 있습니다."),
	CAR_NAME_RANGE("자동차 이름이 5자를 초과합니다."),
	OVER_HUNDRED_CAR("자동차 개수는 1 ~ 99까지 가능합니다."),
	INVALID_NUMBER_RANGE("시도 횟수는 1 ~ 9,999까지 가능합니다.");
	private final String message;

	ErrorStatus(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
