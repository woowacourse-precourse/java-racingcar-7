package racingcar.validation;

public enum RaceValidatorException {
    NULL_INPUT("입력된 값이 없습니다."),
    INVALID_CAR_NAME("자동차의 이름은 5글자 이하여야 합니다."),
    STARTED_WITH_COMMA("경주에 참여하는 자동차 목록을 제대로 입력해 주세요."),
    INVAILD_CAR_NAMES("자동차 이름이 충분하지 않습니다. 다시 입력해 주세요."),
    NON_NUMERIC_TRY_COUNT("시도할 횟수를 숫자로 입력해 주세요."),
    NEGATIVE_TRY_COUNT("시도할 횟수는 양의 정수로 입력해 주세요.");

    private final String message;

    RaceValidatorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
