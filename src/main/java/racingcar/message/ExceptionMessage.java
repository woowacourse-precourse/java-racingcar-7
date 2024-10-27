package racingcar.message;

public enum ExceptionMessage implements MessageProvider {
    CAR_NAME_TOO_LONG("5자 미만이어야 합니다."),
    CAR_NAME_DUPLICATE("중복된 자동차 이름이 있습니다."),
    CAR_NAME_EMPTY("자동차 이름은 비어 있을 수 없습니다."),
    NOT_A_NUMBER("숫자를 입력해주세요"),
    NUMBER_PARSE_ERROR("표현 범위를 벗어났습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
