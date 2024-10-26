package racingcar.message;

public enum ErrorMessage implements Message {

    MINIMUM_REQUIRED_CARS("경주에 필요한 최소 자동차 대수는 2대입니다."),
    POSITIVE_TRY_COUNT_REQUIRED("시도할 횟수는 양수여야 합니다."),
    NUMERIC_TRY_COUNT_REQUIRED("시도할 횟수는 숫자여야 합니다."),
    CAR_NAME_REQUIRED("자동차 이름이 비어있습니다."),
    CAR_NAME_MAX_LENGTH("자동차 이름은 5자 이하 여야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
