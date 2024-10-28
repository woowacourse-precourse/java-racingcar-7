package racingcar.validator;

public enum ErrorMessages {

    INVALID_CAR_NAME_MAX_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    INVALID_CAR_NAME_MIN_LENGTH("자동차 이름은 1자 이상이어야 합니다."),
    INVALID_COUNT_RANGE("레이스 횟수는 1 이상이어야 합니다."),
    INVALID_COUNT_TYPE("레이스 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

