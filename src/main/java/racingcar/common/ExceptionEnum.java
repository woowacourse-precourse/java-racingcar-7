package racingcar.common;

// 예외 메시지를 관리하는 Enum 클래스
public enum ExceptionEnum {

    // 자동차 이름 관련 예외 메시지
    INVALID_MIN_CAR_NAME_LENGTH("자동차 이름은 최소 1글자 이상이어야 합니다."), INVALID_MAX_CAR_NAME_LENGTH(
            "자동차 이름은 5글자를 초과할 수 없습니다."), EMPTY_CAR_NAME_LIST("자동차 이름 리스트가 비어있습니다."), EMPTY_CAR_NAME(
            "자동차 이름은 빈 입력일 수 없습니다."), DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다. 중복된 자동차 이름 : "), INVALID_CAR_NAME_FORMAT(
            "자동차 이름으로 특수문자, 숫자 또는 한글은 사용할 수 없습니다."), NULL_CAR_NAME("자동차 이름은 null일 수 없습니다."),

    // 시도 횟수 관련 예외 메시지
    NEGATIVE_ATTEMPT_COUNT("시도 횟수는 음수일 수 없습니다."), ZERO_ATTEMPT_COUNT("시도 횟수는 0일 수 없습니다."), NON_INTEGER_ATTEMPT_COUNT(
            "시도 횟수는 정수여야 합니다."), EMPTY_ATTEMPT_COUNT("시도 횟수는 빈 입력일 수 없습니다."), NULL_ATTEMPT_COUNT(
            "시도 횟수는 null일 수 없습니다.");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}