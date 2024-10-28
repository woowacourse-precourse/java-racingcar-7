package racingcar.exception;

public enum InputCountExceptionMessage {
    BLANK_COUNT("공백이 입력되었습니다."),
    IMPOSSIBLE_CONVERT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    INVALID_INTEGER_SCOPE("int 자료형의 범위를 넘어서는 입력값입니다."),
    UNDER_MINIMUM_COUNT("0 이하의 숫자입니다.");

    private String message;

    InputCountExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
