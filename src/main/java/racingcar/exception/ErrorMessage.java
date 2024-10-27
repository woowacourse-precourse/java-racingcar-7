package racingcar.exception;

public enum ErrorMessage {

    EMPTY_CAR_NAMES("빈 자동차 이름 목록입니다."),
    EMPTY_CAR_NAME("자동차의 이름은 비어있을 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차의 이름은 5자를 넘길 수 없습니다."),
    DUPLICATED_CAR_NAME("동일한 자동차 이름이 존재합니다."),

    INVALID_NUMBER_FORMAT("숫자만 입력할 수 있습니다."),
    RACE_ROUND_OUT_OF_BOUND("진행 횟수의 범위는 0부터 100까지입니다."),
    INVALID_INTEGER_FORMAT("유효한 정수를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
