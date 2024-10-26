package racingcar.message;

public enum ExceptionCode {

    CAR_NAME_LENGTH_5("자동차 이름은 5자 이하로 입력해 주세요."),
    CAR_NAME_BLANK("자동차 이름은 한 글자 이상 입력해 주세요."),
    INVALID_TURN("시도 횟수는 숫자로 입력해 주세요.");

    private final String description;

    ExceptionCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
