package racingcar.exception;

public enum Exception {
    TOO_MANY_CARS("자동차가 너무 많습니다."),
    NOT_ENOUGH_CARS("자동차가 너무 적습니다."),
    INVALID_EMPTY_CAR_NAME("자동차 이름은 빈 문자열일 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름이 너무 깁니다: "),
    INVALID_CAR_NAME_FORMAT("이름은 숫자나 기호, 공백을 포함할 수 없습니다: "),
    CAR_NAME_ALREADY_EXIST("이름이 중복됩니다: "),

    TRIAL_COUNT_NOT_A_NUMBER("시도 횟수는 숫자여야 합니다."),
    TRIAL_COUNT_TOO_LARGE("시도 횟수가 너무 큽니다."),
    TRIAL_COUNT_TOO_SMALL("시도 횟수가 너무 적습니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
