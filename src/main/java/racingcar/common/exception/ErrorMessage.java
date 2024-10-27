package racingcar.common.exception;

public enum ErrorMessage {

    CAR_POSITION_OUT_OF_RANGE("자동차가 더 이상 전진할 수 없습니다."),
    DUPLICATE_CAR("중복된 자동차를 등록할 수 없습니다."),
    CAR_NAME_EMPTY("자동차 이름이 비어 있어서는 안됩니다."),
    CAR_NAME_LENGTH_OVER_FIVE("자동차 이름이 5글자를 넘어서는 안됩니다.")
    ;

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }
}
