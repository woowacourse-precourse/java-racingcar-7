package racingcar.constant;

public enum ExceptionMessage {
    CAR_NAME_EMPTY_STRING("자동차 이름은 빈 값을 사용할 수 없습니다."),
    CAR_NAME_LENGTH_LIMITATION("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAMES_DUPLICATE("자동차 이름은 중복으로 사용할 수 없습니다."),
    INPUT_EMPTY_STRING("값을 입력해주세요."),
    INPUT_NON_DIGIT_CHARACTER("숫자(0-9)만 입력할 수 있습니다."),
    INPUT_INVALID_INTEGER_RANGE("정수 범위의 값만 입력할 수 있습니다.")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
