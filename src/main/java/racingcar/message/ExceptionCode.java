package racingcar.message;

public enum ExceptionCode {

    CAR_NAME_LENGTH_5("자동차 이름은 5자 이하로 입력해 주세요."),
    CAR_NAME_BLANK("자동차 이름은 한 글자 이상 입력해 주세요."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복을 허용하지 않습니다."),
    INVALID_TURN("시도 횟수를 숫자로 입력해 주세요."),
    TURN_MORE_THAN_0("시도 횟수는 1회 이상으로 입력해주세요.");

    private final String description;

    ExceptionCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
