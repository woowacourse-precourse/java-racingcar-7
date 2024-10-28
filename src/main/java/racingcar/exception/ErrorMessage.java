package racingcar.exception;

public enum ErrorMessage {
	// Prefix
	ERROR_PREFIX("[ERROR] "),

	// Error Messages
	INPUT_BLANK("입력값이 비어있습니다."),
	ATTEMPT_COUNT_NOT_DIGIT("시도 횟수는 정수여야 합니다."),
	ATTEMPT_COUNT_NOT_POSITIVE("시도 횟수는 0보다 커야 합니다."),

	CAR_NAME_BLANK("자동차 이름은 비어있을 수 없습니다."),
	CAR_NAME_LENGTH_EXCEEDED("자동차 이름이 최대 길이를 초과했습니다."),
	CAR_NAME_NOT_ALPHABET("자동차 이름은 알파벳으로만 구성되어야 합니다."),

	PARTICIPANT_COUNT_NOT_ENOUGH("참가자 수가 최소 인원을 충족하지 않습니다."),
	CAR_NAME_DUPLICATED("차량 이름은 중복되지 않아야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return ERROR_PREFIX.message + message;
	}
}
