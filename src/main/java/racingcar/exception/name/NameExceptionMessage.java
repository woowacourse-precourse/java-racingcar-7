package racingcar.exception.name;

public enum NameExceptionMessage {
	HAS_DUPLICATED_NAME("중복된 이름이 존재합니다."),
	NAME_TOO_LONG("5글자 이하의 이름만 입력 가능합니다."),
	NAME_IS_NOT_BLANK("공백 이름은 입력할 수 없습니다.");

	private final String message;

	NameExceptionMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
