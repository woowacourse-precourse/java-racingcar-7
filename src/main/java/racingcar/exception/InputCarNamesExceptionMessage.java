package racingcar.exception;

public enum InputCarNamesExceptionMessage {
    BLANK_CAR_NAME("공백이 입력되었습니다."),
    DUPLICATED_CAR_NAME("자동차 이름이 중복되어 입력되었습니다."),
    INVALID_CAR_NAME("이름의 길이가 5자를 초과한 유효하지 않은 이름입니다.");

    private final String message;

    InputCarNamesExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
