package racingcar.exception.constants;

public enum ErrorMessage {

    EMPTY_CAR_NAME_NOT_ALLOWED("자동차 이름이 빈 값입니다."),
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름이 5자를 초과했습니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름입니다."),
    INVALID_NUMBER("유효하지 않은 숫자입니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
