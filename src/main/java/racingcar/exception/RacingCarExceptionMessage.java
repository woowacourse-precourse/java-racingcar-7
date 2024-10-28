package racingcar.exception;

public enum RacingCarExceptionMessage {

    INVALID_NUMBER_EXCEPTION("값은 0에서 10사이의 정수여야 합니다."),
    NUMBER_IS_NOT_NULL("숫자는 빈 값이 될 수 없습니다."),
    NAME_LENGTH_OUT_OF_RANGE("이름은 1자이상 5자 이하만 가능합니다."),
    NAME_IS_NOT_NULL("이름은 빈 값이 될 수 없습니다."),
    INPUT_IS_NOT_EMPTY("입력 값은 빈 값이 될 수 없습니다."),
    INPUT_IS_NOT_COMMA("입력 값은 ,만 입력할 수 없습니다."),
    REPETITIONS_IS_ACCESS_OVER_ONCE("반복 횟수는 1이상 만 입력할 수 있습니다."),
    CAR_NAME_DUPLICATE_EXCEPTION("반복 횟수는 1이상 만 입력할 수 있습니다."),
    POSITION_MUST_BE_INTEGER("반복 횟수는 1이상 만 입력할 수 있습니다.");


    private final String errorMessage;

    RacingCarExceptionMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
