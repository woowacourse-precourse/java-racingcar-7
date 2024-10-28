package racingcar.message;

public enum ExceptionMessage {
    INVALID_CAR_NAME_LENGTH("[ERROR] 자동차 이름을 5자 이하로 입력해 주세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
