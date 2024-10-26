package racingcar.exception;

public enum ErrorMessage {

    INVALID_INPUT("유효하지 않은 입력입니다."),
    INTEGER_TYPE_ERROR("유효하지 않은 숫자입니다."),
    NOT_POSITIVE_NUMBER("양수가 아닌 값은 유효하지 않습니다.")
    ;

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
