package racingcar.exception;

public enum ExceptionMessages {
    TOO_LONG_NAME("자동차 이름은 5자 이하만 가능합니다."),
    INPUT_NOT_NUMBER("입력값은 숫자만 가능합니다"),
    NEGATIVE_NUMBER("양수만 입력 가능합니다."),
    NULL_INPUT("입력값이 null입니다."),
    EMPTY_INPUT("입력값이 비어있습니다."),
    EMPTY_CAR_NAME("자동차 이름이 비어있습니다."),
    DUPLICATE_NAME("중복된 자동차 이름입니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
