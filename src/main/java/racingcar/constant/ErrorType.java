package racingcar.constant;

public enum ErrorType {
    CAR_NAME_TOO_LONG("차량 이름은 5자 이하만 가능합니다."),
    EMPTY_INPUT("입력값이 없습니다."),
    NOT_ENOUGH_CAR("경기에 참가하는 차량은 2대 이상이어야 합니다."),
    RACE_COUNT_TOO_LOW("레이스 횟수는 1 이상만 가능합니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
