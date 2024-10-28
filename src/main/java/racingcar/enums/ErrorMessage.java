package racingcar.enums;

public enum ErrorMessage {
    INVALID_CAR_NAME("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    INVALID_ROUNDS("횟수는 1 이상의 정수여야 합니다."),
    INVALID_INTEGER("정수를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}