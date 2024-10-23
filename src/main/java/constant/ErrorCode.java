package constant;

public enum ErrorCode {
    CAR_NAME_LENGTH_EXCEED("자동차 이름은 5자를 초과할 수 없습니다."),
    CAR_NAME_NOT_EMPTY("자동차 이름은 공백일 수 없습니다."),
    CAR_NAME_DUPLICATE("자동차 이름은 중복일 수 없습니다."),
    INVALID_CAR_COUNT("경주할 자동차 수가 부족합니다."),

    INVALID_ATTEMPT_TYPE("시도 횟수는 숫자를 입력해야 합니다."),
    ATTEMPT_SHOULD_POSITIVE("시도 횟수는 양수를 입력해야 합니다.");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
