package racingcar.message;

public enum VaildatorMessage {
    EMPTY_INPUT("자동차 이름은 비어 있을 수 없습니다."),
    OVER_5_INPUT("자동차 이름은 5자 이하여야 합니다."),
    NOT_NUM_INPUT("시도 횟수는 유효한 숫자여야 합니다."),
    SAME_NAME_INPUT("같은 이름을 입력할 수 없습니다.");

    private String message;

    VaildatorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
