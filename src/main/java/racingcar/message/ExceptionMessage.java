package racingcar.message;

public enum ExceptionMessage {

    INVALID_RANDOM_NUMBER_EXCEPTION_MESSAGE("유효하지 않은 무작위 값이 들어왔습니다. " +
            "(무작위 값은 0이상 9이하의 값이어야 합니다.)");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
