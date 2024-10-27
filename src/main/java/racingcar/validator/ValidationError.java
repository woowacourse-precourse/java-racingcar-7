package racingcar.validator;

public enum ValidationError {
	ERROR_CARS_SIZE_ONE("두명 이상의 참가자를 입력해 주세요."),
	ERROR_CAR_NAME_OVER_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
	ERROR_CAR_NAME_EMPTY("빈 문자열은 자동차 이름이 될 수 없습니다."),
	ERROR_ATTEMPT_COUNT_NOT_NUMBER_OR_OVERFLOW("계산 범위를 초과하였거나 숫자가 아닙니다."),
	ERROR_ATTEMPT_COUNT_NOT_POSITIVE_NUMBER("시도할 횟수는 양수만 가능합니다.");

	private final String message;

	ValidationError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
