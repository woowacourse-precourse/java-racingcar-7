package racingcar.constant;

public enum ExceptionMessage {

    CAR_NAME_NOT_ALLOW_SPACE("자동차 이름에는 공백이 올 수 없습니다."),
    CAR_NAME_LENGTH_MUST_BE_LESS("자동차 이름은 %d자 이하만 가능합니다.%n"),
    TRY_COUNT_MUST_BE_NUMBER("시도 횟수는 숫자여야 합니다."),
    TRY_COUNT_MUST_BE_POSITIVE("시도 횟수는 양수여야 합니다."),
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(message);
    }

    public String getMessage(int carNameLength) {
        if (this.equals(CAR_NAME_LENGTH_MUST_BE_LESS)) {
            return String.format(message, carNameLength);
        }
        return String.format(message);
    }
}
