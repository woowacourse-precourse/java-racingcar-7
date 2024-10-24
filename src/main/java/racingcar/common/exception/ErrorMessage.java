package racingcar.common.exception;

public enum ErrorMessage {
    EMPTY_INPUT("입력값이 비어 있습니다. 값을 입력해주세요."),

    RACING_CAR_MINIMUM_TWO_REQUIRED("경주할 자동차는 2대 이상이어야 합니다."),
    RACING_CAR_NAME_MUST_BE_ENGLISH_OR_KOREAN("자동차 이름은 영어 또는 한글로만 이루어져야 합니다."),
    RACING_CAR_NAME_MAX_LENGTH_EXCEEDED("자동차 이름은 5자 이하이어야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
