package racingcar.util;

public enum ValidationError {
    CAR_NAME_NOT_EMPTY("자동차 이름은 비어 있을 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 %d자를 초과할 수 없습니다."),
    CAR_NAME_NOT_CONTAINS_SPACE("차량 이름 앞뒤에 공백이 포함될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    SINGLE_CAR_WITH_COMMA("차량이 한 대일 때 쉼표는 포함될 수 없습니다."),
    TRAIL_NUMBER_NOT_EMPTY("시도 횟수는 비어 있을 수 없습니다."),
    TRIAL_NUMBER_NOT_NUMERIC("시도횟수는 숫자로 입력해야 합니다."),
    TRIAL_NUMBER_TOO_LOW("시도 횟수는 1 이상의 숫자이여야 합니다.");

    private final String message;

    ValidationError(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
