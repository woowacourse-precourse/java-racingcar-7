package racingcar.message;

public enum ErrorMessage {
    INVALID_COMMA_INPUT("자동차 이름으로 ',' 는 사용할 수 없습니다."),
    INVALID_NUMBER_FORMAT("시도 횟수 입력은 0 이상의 정수 형식이어야 합니다."),
    CAR_NAME_IS_EMPTY("자동차 이름이 비어있습니다."),
    CAR_NAME_IS_SPACE("자동차 이름이 공백으로만 구성되었습니다."),
    CAR_NAME_IS_DUPLICATED("자동차 이름이 중복되었습니다."),
    CAR_NAME_IS_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_NAME_CHARACTER("자동차 이름에 유효하지 않은 특수문자가 포함되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
