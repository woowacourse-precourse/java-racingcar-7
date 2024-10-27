package racingcar.common.exception;

public enum CarErrorMessages {
	OVER_MAX_LENGTH("자동차 이름 글자 수 제한 초과입니다"),
	BLANK_NOT_ALLOWE("입력값이 빈칸 혹은 공백일 수 없습니다."),
	DUPLICATE_NAME("중복된 자동차 이름이 존재합니다."),
	;

	private final String message;

	CarErrorMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
