package racingcar.constant;

public enum ErrorMessage {
    USER_INPUT_NONE("빈 값을 입력받았습니다"),
    ALL_NONE_RACING_CAR("경주할 자동차가 없는 것 같습니다"),
    OVER_CAR_NAME("차량 입력값의 크기를 초과했습니다"),
    NONE_CAR_NAME("자동차 이름이 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
