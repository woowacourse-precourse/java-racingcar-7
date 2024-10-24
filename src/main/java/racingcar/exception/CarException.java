package racingcar.exception;

public enum CarException {
    CAR_NAME_IS_NULL_OR_EMPTY("자동차 이름은 null이거나 빈 문자열일 수 없습니다."),
    CAR_NAME_IS_OVER_FIVE("자동차 이름은 5자를 초과할 수 없습니다.");


    private final String message;

    CarException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
