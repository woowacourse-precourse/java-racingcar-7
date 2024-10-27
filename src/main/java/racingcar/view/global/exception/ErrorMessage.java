package racingcar.view.global.exception;

public enum ErrorMessage {
    DUPLICATE_CAR_NAME_ERROR("중복된 자동차 이름이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
