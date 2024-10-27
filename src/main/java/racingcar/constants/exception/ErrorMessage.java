package racingcar.constants.exception;

public enum ErrorMessage {

    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME_NOT_ALLOWED("자동차 이름은 중복될 수 없습니다."),
    EMPTY_CAR_NAME_NOT_ALLOWED("자동차 이름은 비어있을 수 없습니다."),
    INVALID_CAR_NAME_FORMAT("입력은 쉼표로 구분된 영어 이름만 가능합니다."),
    FORWARD_COUNT_MUST_BE_IN_RANGE("시도할 횟수는 1~100 사이의 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}