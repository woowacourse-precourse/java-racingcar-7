package racingcar.common.constant;

public enum ExceptionMessage {
    INVALID_CAR_NAME_CHARACTERS("자동차의 이름에 영문자, 한글, 숫자를 제외한 다른 문자가 포함되었습니다."),
    CAR_NAME_TOO_LONG("자동차의 이름이 5자를 초과했습니다."),
    ROUND_VALUE_OUT_OF_RANGE("사용자가 입력하는 시도값이 0 ~ 2,147,483,647 범위 내에 존재하지 않습니다."),
    ROUND_VALUE_NOT_INTEGER("사용자가 입력하는 시도값이 정수가 아닌 실수입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
