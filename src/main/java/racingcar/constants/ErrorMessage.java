package racingcar.constants;

public enum ErrorMessage {
    CAR_NAME_CAN_NOT_BE_EMPTY("자동차 이름은 빈 값이 될 수 없습니다."),
    RACE_COUNT_DOES_NOT_HAVE_CHARACTER("시도 횟수에 숫자 이외의 문자가 포함되어 있습니다."),
    RACE_COUNT_CAN_NOT_BE_EMPTY("시도 횟수는 빈 값이 될 수 없습니다."),
    RACE_COUNT_CAN_NOT_BE_ZERO("시도 횟수는 0이 될 수 없습니다.");

    private final String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
