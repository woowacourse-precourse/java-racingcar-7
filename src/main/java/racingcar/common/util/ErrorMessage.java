package racingcar.common.util;

public enum ErrorMessage {

	CAR_LIST_EMPTY_ERROR("자동차는 1대 이상이어야합니다."),
	CAR_LIST_INDEX_ERROR("유효하지않은 인덱스입니다."),
	NUMBER_FORMAT_ERROR("정수로 변환할 수 없는 문자열입니다."),
	STRING_EMPTY_ERROR("문자열이 비어있습니다."),
	CAR_NAME_LENGTH_ERROR("자동차 이름은 비우거나 5자를 넘을 수 없습니다."),
	LAP_COUNT_ERROR("시도 횟수는 음수가 될 수 없습니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
