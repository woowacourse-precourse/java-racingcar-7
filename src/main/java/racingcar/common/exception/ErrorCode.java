package racingcar.common.exception;

public enum ErrorCode {

    LENGTH_ERROR("자동차의 이름은 1자 이상, 5자 이하여야 합니다."),
    PARSING_ERROR("시도할 횟수는 숫자여야 합니다."),
    NAMES_ERROR("잘못된 입력입니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
