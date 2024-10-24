package racingcar.error;

public enum InputError {
    INVALID_CAR_NAME_FORMAT("한글과 영어 소문자로 작성해주세요."),
    INVALID_CAR_NAME_LENGTH("5자 이하의 이름을 작성해주세요."),

    INVALID_TRIAL_COUNT_TYPE("정수를 입력해주세요. (1 ~ 2147483647)"),
    INVALID_TRIAL_COUNT_RANGE("1 이상의 정수를 입력해주세요.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
