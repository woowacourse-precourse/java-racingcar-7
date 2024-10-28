package racingcar.model.domain;

public enum ErrorMessage {
	EMPTY_CAR_NAME("자동차 이름은 비어있지 않아야 합니다."),
	OVER_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
	DUPLICATE_CAR_NAME("자동차 이름은 중복되지 않아야 합니다."),
	NEGATIVE_ATTEMPT_NUMBER("시도 횟수는 1 이상이어야 합니다."),
	NOT_NUMBER_FORMAT("횟수는 숫자로 입력해 주세요.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}