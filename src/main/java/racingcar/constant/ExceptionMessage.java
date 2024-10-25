package racingcar.constant;

public enum ExceptionMessage {

    CAR_NAME_NOT_ALLOW_SPACE("자동차 이름에는 공백이 올 수 없습니다."),
    TRY_COUNT_MUST_BE_NUMBER("시도 횟수는 숫자여야 합니다."),
    TRY_COUNT_MUST_BE_POSITIVE("시도 횟수는 양수여야 합니다."),
    ;

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
