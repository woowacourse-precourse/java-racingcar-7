package racingcar.common;

public enum ExceptionMessage {
    NAME_INVALID_EMPTY("자동차 이름 형식이 올바르지 않습니다."),
    NUMBER_INVALID_FORMAT("횟수 형식이 올바르지 않습니다."),
    NOT_ENOUGH_INPUTS("입력이 충분하지 않습니다.")
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
