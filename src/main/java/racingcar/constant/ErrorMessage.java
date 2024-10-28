package racingcar.constant;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    DELIMITER_CANNOT_BE_CONSECUTIVE("구분자는 연속으로 사용될 수 없습니다."),
    DELIMITER_CANNOT_BE_AT_START_OR_END("구분자는 입력의 시작이나 끝에 위치할 수 없습니다."),
    MUST_BE_NUMERIC("유효한 숫자를 입력해야 합니다."),
    MAX_ATTEMPTS_EXCEEDED("이동 횟수는 최대 10회까지 입력 가능합니다."),
    MAX_CARS_EXCEEDED("자동차 이름은 최대 5개까지 입력 가능합니다."),
    NAME_CANNOT_BE_EMPTY("이름값이 비어있습니다."),
    DUPLICATE_NAMES_NOT_ALLOWED("중복된 이름이 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
