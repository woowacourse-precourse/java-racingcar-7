package racingcar.exception;

public enum GeneralError implements ErrorMessage {
    EMPTY_INPUT("입력값이 비어있습니다."),
    ;

    final private String message;

    GeneralError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
