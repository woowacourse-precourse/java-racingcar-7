package racingcar.constant;

public enum Message {
    CAR_NAME_EMPTY_VALIDATION_MESSAGE("자동차에 이름을 부여하지 않았습니다."),
    CAR_NAME_LENGTH_LIMIT_VALIDATION_MESSAGE("자동차 이름은 5자 이하여야 합니다.");

    private String message;
    private Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}