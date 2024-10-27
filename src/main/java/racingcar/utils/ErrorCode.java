package racingcar.utils;

public enum ErrorCode {
    NAME_EMPTY_ERROR("이름은 공백일 수 없습니다."),
    NAME_DUPLICATE_ERROR("이름은 중복될 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
