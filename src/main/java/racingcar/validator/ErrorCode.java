package racingcar.validator;

public enum ErrorCode {

    CAR_NAME_TOO_LONG("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_CANNOT_BE_EMPTY("자동차 이름은 공백이 될 수 없습니다."),
    CAR_NAME_DUPLICATE("자동차 이름은 중복될 수 없습니다."),
    REPEAT_COUNT_MUST_BE_POSITIVE("반복 횟수는 1 이상의 양의 정수여야 합니다."),
    REPEAT_COUNT_EXCEEDS_INT_MAX("반복 횟수는 int의 최대값을 초과할 수 없습니다."),
    REPEAT_COUNT_MUST_BE_INTEGER("반복 횟수는 숫자여야 합니다."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
