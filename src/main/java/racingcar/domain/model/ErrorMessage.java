package racingcar.domain.model;

public enum ErrorMessage {

	CAR_LIST_EMPTY_ERROR("자동차는 1대 이상이어야합니다."),
	CAR_LIST_INDEX_ERROR("유효하지않은 인덱스입니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
