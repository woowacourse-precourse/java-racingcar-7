package racingcar.message;

public enum ErrorMessage {
    EMPTY_ARG("아무 값도 입력되지 않았습니다."),
    NON_NUMBER("숫자가 아닌 값이 입력됐습니다."),
    NAME_LENGTH("자동차 이름 길이가 짧습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}