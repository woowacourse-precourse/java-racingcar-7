package racingcar;

public enum ErrorMessages {
    EMPTY_CAR_NAMES("자동차 이름은 비어있을 수 없습니다."),
    WHITE_SPACE_INPUT("입력에 공백이 포함되어 있습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
