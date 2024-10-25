package racingcar.common;

// 예외 메시지를 관리하는 Enum 클래스
public enum ExceptionEnum {

    // 자동차 이름 관련 예외 메시지
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5글자를 초과할 수 없습니다."),
    EMPTY_CAR_NAME("자동차 이름은 빈 입력일 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복일 수 없습니다."),
    INVALID_CAR_NAME_FORMAT("자동차 이름으로 특수문자, 숫자 또는 한글은 사용할 수 없습니다."),

    // 시도 횟수 관련 예외 메시지
    NEGATIVE_ATTEMPT_COUNT("시도 횟수는 음수일 수 없습니다."),
    ZERO_ATTEMPT_COUNT("시도 횟수는 0일 수 없습니다."),
    NON_INTEGER_ATTEMPT_COUNT("시도 횟수는 정수여야 합니다."),
    NON_NUMERIC_ATTEMPT_COUNT("시도 횟수에는 숫자만 입력 가능합니다.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}