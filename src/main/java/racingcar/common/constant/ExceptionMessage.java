package racingcar.common.constant;

public enum ExceptionMessage {
    INVALID_CAR_NAME_CHARACTERS("자동차의 이름에 영문자, 한글, 숫자를 제외한 다른 문자가 포함되었습니다."),
    CAR_NAME_TOO_LONG("자동차의 이름이 5자를 초과했습니다."),
    ROUND_VALUE_NOT_INTEGER("사용자가 입력한 경주 진행 횟수가 표현할 수 있는 정수(-2147483648 ~ 2147483647)가 아닙니다."),
    ROUND_VALUE_NOT_POSITIVE("사용자가 입력한 경주 진행 횟수가 음의 정수입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
