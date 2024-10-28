package racingcar.exception.message;

public enum Error {

    INVALID_LENGTH("입력 가능한 글자수의 범위를 벗어났습니다."),
    EMPTY_VALUE("공백 혹은 빈 문자열은 입력할 수 없습니다"),
    NOT_NUMERIC("숫자 이외에는 입력할 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
