package racingcar.exception;

public enum ErrorMessage {

    CAR_NAME_NULL_OR_EMPTY("자동차 이름을 입력해야 합니다."),
    NOT_BLANK("공백을 입력할 수 없습니다."),
    SEQUENCE_DELIMITER("구분자를 연속해서 입력할 수 없습니다."),
    TRY_COUNT_NULL_OR_EMPTY("시도 횟수를 입력해야 합니다."),
    INVALID_TRY_COUNT("시도 횟수는 1이상의 정수로 입력해야 합니다."),
    INVALID_CAR_NAME("자동차 이름은 5자를 초과할 수 없습니다."),
    INVALID_POSITION("위치값은 음수가 될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    MINIMUM_TRY_COUNT("시도횟수는 최소 1회 이상이여아 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
