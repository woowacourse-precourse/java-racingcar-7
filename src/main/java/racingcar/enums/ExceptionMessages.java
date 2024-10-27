package racingcar.enums;

public enum ExceptionMessages {
    EMPTY_INPUT("자동차 이름은 비어 있을 수 없습니다."),
    INVALID_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_COMMA_INPUT("자동차 이름으로 ',' 는 사용할 수 없습니다."),
    INVALID_NUMBER_FORMAT("시도 횟수 입력은 0 이상의 정수 형식이어야 합니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
