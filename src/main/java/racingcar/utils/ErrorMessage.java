package racingcar.utils;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다."),
    INVALID_CAR_NAME("사용 불가능한 차 이름입니다. 5자 이하만 가능합니다."),
    INVALID_COUNT("처리 불가능한 횟수입니다.");

    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
