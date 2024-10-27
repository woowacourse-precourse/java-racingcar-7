package racingcar.exception;

public enum ErrorCode {

    CAR_NAME_LENGTH_LONG("자동차 이름은 5자 이하만 가능합니다"),
    CAR_NAME_BLANK("자동차 이름은 공백이 아니어야 합니다"),
    CAR_COUNT_ZERO("자동차는 1대 이상이어야 합니다."),
    TRY_COUNT_INVALID("시도 횟수는 1회 이상이어야 합니다."),
    TRY_COUNT_NOT_NUMBER("시도 횟수는 숫자여야 합니다");

    private final String name;

    ErrorCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
