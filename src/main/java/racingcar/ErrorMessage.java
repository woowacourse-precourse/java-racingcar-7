package racingcar;

public enum ErrorMessage {
    INVALID_INPUT("잘못된 입력입니다"),
    CAR_NAME("자동차 이름은 5자 이하만 가능합니다."),
    TRY_COUNT("잘못된 입력입니다. 경주를 시도할 횟수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
