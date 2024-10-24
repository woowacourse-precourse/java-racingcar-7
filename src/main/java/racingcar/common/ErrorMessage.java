package racingcar.common;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 이름은 5자 이하만 가능합니다."),
    EMPTY_CAR_NAME("자동차 이름을 입력해주세요."),
    INVALID_TRY_COUNT("시도 횟수는 0보다 커야 합니다."),
    EMPTY_CAR_LIST("자동차 목록이 비어 있습니다."),
    CAN_NOT_CALCULATE_DISTANCE("최대 이동 거리를 계산할 수 없습니다.");

    private final String message;

    ErrorMessage(final String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
