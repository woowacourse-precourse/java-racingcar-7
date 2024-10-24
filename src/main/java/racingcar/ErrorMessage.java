package racingcar;

public enum ErrorMessage {
    EOF("입력값이 없어 경주를 시작 할 수 없습니다."),
    WRONG_TRY_COUNT("시도할 횟수가 올바르지 않습니다."),
    WRONG_CAR_NAME("이름의 길이가 5글자를 초과하였습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
