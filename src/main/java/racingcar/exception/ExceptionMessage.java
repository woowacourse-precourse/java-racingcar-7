package racingcar.exception;

public enum ExceptionMessage {
    ERROR_MESSAGE("[ERROR] "),
    CAR_NAME_SEPARATOR_EXCEPTION_MESSAGE("자동차 이름은 쉼표(,)로 구분되어야 합니다. 자동차 경주는 두 대 이상 가능합니다."),
    CAR_NAME_LENGTH_EXCEPTION_MESSAGE("자동차 이름은 5자 이하만 가능합니다."),
    CAR_NAME_EMPTY_EXCEPTION_MESSAGE("자동차 이름이 존재하지 않습니다. 자동차 경주는 두 대 이상 가능합니다."),
    CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE("자동차 이름은 중복되지 않아야 합니다."),
    RACING_ROUND_NUMBER_EXCEPTION_MESSAGE("자동차 이동 시도 횟수는 숫자로만 이루어져야 하며, Integer 범위 내(1~2,147,483,647)의 수여야 합니다."),
    RACING_ROUND_POSITIVE_NUMBER_EXCEPTION_MESSAGE("자동차 이동 시도 횟수는 1이상 양수여야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE.message + message;
    }
}
