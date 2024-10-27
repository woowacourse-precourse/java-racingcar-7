package racingcar.exception;

public enum ErrorMessage {
    BLANK_CAR_NAME_INPUT("경주할 자동차의 이름을 입력해 주세요."),
    BLANK_CAR_NAME("이름을 지정하지 않은 자동차가 있습니다."),
    TOO_LONG_CAR_NAME("자동차의 이름은 5자 이하로 설정해 주세요."),
    DUPLICATED_CAR_NAME("중복된 자동차 이름이 존재합니다."),
    BLANK_ROUND_COUNT_INPUT("시도할 횟수를 입력해 주세요."),
    INVALID_ROUND_COUNT("양의 정수를 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
