package racingcar.exception;

public enum ErrorMessage {

    LENGTH_OVER_FIVE("레이싱카 이름은 5자 이하만 가능합니다."),
    IS_NOT_VALID_NUMBER("숫자가 아니거나, 허용 범위를 초과한 값이 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
