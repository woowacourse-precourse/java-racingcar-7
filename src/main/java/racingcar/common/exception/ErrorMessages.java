package racingcar.common.exception;

public enum ErrorMessages {
	OVER_MAX_LENGTH("글자 수 제한 초과입니다"),
	BLANK_NOT_ALLOWE("입력값이 빈칸 혹은 공백일 수 없습니다."),
	DUPLICATED("중복된 값이 존재합니다."),
	MUST_BE_WHOLE_NUMBER("입력값은 정수만 가능합니다."),
	;

	private final String message;

	ErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
