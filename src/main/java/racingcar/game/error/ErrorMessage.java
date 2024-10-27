package racingcar.game.error;

public enum ErrorMessage {
    INVALID_INPUT("입력값은 공백이거나 비어있을 수 없습니다."),
    CAR_NAME_LENGTH("자동차 이름의 길이는 5를 넘을 수 없습니다."),
    ATTEMPT_COUNT_TYPE("시도할 횟수는 문자일 수 없습니다."),
    CANNOT_PARTICIPATE_DUPLICATE_CAR("중복된 자동차는 참여할 수 없습니다.");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}