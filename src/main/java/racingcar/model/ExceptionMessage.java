package racingcar.model;

public enum ExceptionMessage {
    EMPTY_STRING("빈 문자열은 입력할 수 없습니다."),
    INVALID_VALUE("유효하지 않은 횟수입니다."),
    NAME_LENGTH("이름의 길이는 1 이상 5 이하여야 합니다."),
    INVALID_CHARACTER("이름에는 알파벳 대소문자, 숫자, 공백만 입력할 수 있습니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}