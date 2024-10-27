package racingcar.exception;

public enum ExceptionMessage {

    INPUT_BLANK("값을 입력하지 않으셨습니다."),
    TRY_COUNT_OUT_OF_RANGE("최소 %d번, 최대 %d번까지 시도 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

     public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
