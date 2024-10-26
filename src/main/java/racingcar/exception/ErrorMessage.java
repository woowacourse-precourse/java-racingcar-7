package racingcar.exception;

public enum ErrorMessage {
    // 자동차 이름 입력 예외 메세지
    DUPLICATED_CAR_NAME("자동차 이름이 중복될 수 없습니다."),
    NOT_ALLOW_BLANK("자동차 이름은 공백을 허용하지 않습니다."),
    CAR_NAME_NOT_ALLOW_EMPTY("자동차 입력은 비어있을수 없습니다."),
    INVALID_NAME_LENGTH("자동차의 이름은 5자 이하여야합니다."),

    // 시도 횟수 입력 예외 메세지
    NOT_NUMERIC("시도 횟수 입력은 숫자여야 합니다."),
    TRY_NUMBER_NOT_ALLOW_EMPTY("시도 횟수 입력은 비어있을수 없습니다."),
    ONLY_NATURAL_NUMBER("시도 횟수는 음수 혹은 0일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
