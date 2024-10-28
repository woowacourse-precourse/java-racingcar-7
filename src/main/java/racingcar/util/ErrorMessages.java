package racingcar.util;

public enum ErrorMessages {
    INVALID_NAME("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다."),
    INVALID_COUNT("[ERROR] 이동 횟수는 1 이상의 정수여야 합니다."),
    NUMBER_FORMAT("[ERROR] 숫자를 입력해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
