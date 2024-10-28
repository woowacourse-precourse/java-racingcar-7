package racingcar.exception;

public enum CarNameValidationError implements ErrorMessage {
    NAME_NULL("이름은 null이 될 수 없습니다."),
    NAME_EMPTY("이름은 빈 문자열이 될 수 없습니다."),
    NAME_TOO_LONG("이름은 5자 이하여야 합니다."),
    NAME_CONTAINS_SPACE("이름에 공백이 포함될 수 없습니다.");

    final private String message;

    CarNameValidationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
