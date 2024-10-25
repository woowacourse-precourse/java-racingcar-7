package racingcar.view;

public enum ErrorMessage {
    INVALID_CAR_NUMBER("1~5글자 이하의 자동차 이름을 입력해 주세요."),
    INVALID_PLAY_TIMES("양수만 입력해 주세요.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getFormattedMessage() {
        return message;
    }
}
