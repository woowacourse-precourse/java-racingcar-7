package racingcar;

public enum ExceptionCode {

    INVALID_CAR_NAME("C001", "한 대 이상의 자동차 이름을 입력해야 합니다."),
    INVALID_CAR_NAME_LENGTH("C002", "자동차 이름 길이는 6 이상이 될 수 없습니다."),
    INVALID_CAR_NAME_DUPLICATE("C003", "중북된 자동차 이름을 입력할 수 없습니다."),
    INVALID_DELIMITER("C004", "잘못된 구분자를 입력했습니다."),
    INVALID_MOVE_COUNT("C005", "이동 횟수는 숫자를 입력해야 합니다."),
    ;

    private final String code;
    private final String message;

    ExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
