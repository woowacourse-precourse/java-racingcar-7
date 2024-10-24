package racingcar.common;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 이름은 5자 이하만 가능합니다."),
    EMPTY_CAR_NAME("자동차 이름이 입력되지 않았습니다."),
    NAME_INVALID_CHARACTER("자동차 이름에 허용되지 않는 문자가 입력되었습니다."),
    INVALID_CAR_COUNT("경주 자동차는 최소 2개 이상이여야 합니다."),
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
