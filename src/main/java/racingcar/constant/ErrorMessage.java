package racingcar.constant;

public enum ErrorMessage {
    CAR_NAME_LENGTH("자동차 이름은 공백을 제외한 5자 이하의 문자이어야 해요."),
    CAR_NAME_SPACE("자동차 이름 사이에 공백은 허용하지 않아요.");

    private static final String PREFIX_FORMAT = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(PREFIX_FORMAT, message);
    }
}
