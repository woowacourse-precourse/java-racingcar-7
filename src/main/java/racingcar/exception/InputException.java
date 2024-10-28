package racingcar.exception;

public enum InputException {

    TOO_LONG_RACING_CAR_NAME("자동차 이름은 5글자 이하입니다."),
    EMPTY_RACING_CAR_NAME("자동차 이름이 비어있습니다."),
    DUPLICATE_RACING_CAR_NAME("자동차 이름은 중복될 수 없습니다."),

    ATTEMPT_VALUE_IS_ZERO("입력한 시도 횟수가 0입니다."),
    ATTEMPT_VALUE_IS_NEGATIVE("입력한 시도 횟수가 음수입니다."),
    ATTEMPT_VALUE_IS_EMPTY("시도 횟수를 입력해주세요."),
    ATTEMPT_VALUE_IS_STRING("시도 횟수 입력에는 문자가 포함될 수 없습니다.");

    private final String errorMessage;

    InputException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
