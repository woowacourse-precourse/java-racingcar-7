package racingcar.message;

public enum ExceptionMessage implements MessageProvider {
    CAR_NAME_TOO_LONG("5자 미만이어야 합니다."),
    NOT_A_NUMBER("숫자를 입력해주세요"),
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
