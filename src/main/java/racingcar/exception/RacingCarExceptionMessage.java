package racingcar.exception;

public enum RacingCarExceptionMessage {

    INVALID_NUMBER_EXCEPTION("값은 0에서 10사이의 정수여야 합니다."),
    NUMBER_IS_NOT_NULL("숫자는 빈 값이 될 수 없습니다."),
    NAME_LENGTH_OUT_OF_RANGE("이름은 1자이상 5자 이하만 가능합니다."),
    NAME_IS_NOT_NULL("이름은 빈 값이 될 수 없습니다.");

    private final String errorMessage;

    RacingCarExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
