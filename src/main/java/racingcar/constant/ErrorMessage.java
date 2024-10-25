package racingcar.constant;

public enum ErrorMessage {
    USER_INPUT_NONE("빈 값을 입력받았습니다"),
    NONE_CAR("경주할 자동차가 없는 것 같습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
