package racingcar.Exception;

public enum ErrorMessage {

    LENGTH_OVER_FIVE("레이싱카 이름은 5자 이하만 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
