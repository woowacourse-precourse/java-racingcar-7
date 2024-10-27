package racingcar.exception.message;

public enum Error {

    NOT_NUMERIC("숫자 이외에는 입력할 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
