package racingcar.common;

public enum ErrorMessage {

    CAR_NAME_LENGTH_ERROR("자동차 이름은 5자 이하만 가능합니다."),
    ATTEMPT_COUNT_MINIMUM_ERROR("게임 시도 횟수는 2 이상이여야합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
