package racingcar.constants;

public enum ErrorMessage {
    CAR_NAMES_CAN_NOT_BE_EMPTY("자동차 이름은 빈 값이 될 수 없습니다."),
    RACE_COUNT_MUST_NOT_HAVE_CHARACTER("시도 횟수에 숫자 이외의 문자가 포함되어 있습니다."),
    RACE_COUNT_CAN_NOT_BE_EMPTY("시도 횟수는 빈 값이 될 수 없습니다."),
    RACE_COUNT_CAN_NOT_BE_ZERO("시도 횟수는 0이 될 수 없습니다."),
    CAR_NAME_LENGTH_MIN_ONE_MAX_FIVE("자동차 이름은 1자 이상 5자 이하여야 합니다."),
    CAR_NAME_MUST_NOT_HAVE_BLANK("자동차 이름에는 공백이 포함될 수 없습니다.");

    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
