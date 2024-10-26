package racingcar.constant;

public enum ExecptionMessage {
    INPUT_NULL_OR_EMPTY_MESSAGE("빈 값을 입력할 수 없습니다."),
    INPUT_ROUND_COUNT_TYPE_MESSAGE("시도할 횟수는 양의 정수만 입력할 수 있습니다."),
    CAR_NAME_NULL_OR_EMPTY_MESSAGE("자동차 이름은 비어있을 수 없습니다."),
    CAR_NAME_LENGTH_MESSAGE("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_CONTAIN_EMPTY_MESSAGE("자동차 이름에 공백이 포함되어 있습니다."),
    CARS_NAME_DUPLICATED_MESSAGE("중복되는 자동차 이름이 있습니다.");

    private final String message;

    ExecptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
