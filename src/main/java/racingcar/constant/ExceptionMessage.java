package racingcar.constant;

public enum ExceptionMessage {
    INVALID_CAR_COUNT("자동차 이름은 2대 이상 입력해야 합니다."),
    INVALID_CAR_FORMAT("자동차 이름 입력 양식이 올바르지 않습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하여야 합니다."),
    INVALID_CAR_DUPLICATE("자동차 이름은 중복될 수 없습니다."),
    INVALID_COUNT_TYPE("이동 횟수는 숫자만 입력할 수 있습니다."),
    INVALID_COUNT_RANGE("이동 횟수는 1 이상이어야 합니다.");

    private String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
