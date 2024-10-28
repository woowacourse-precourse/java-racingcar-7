package racingcar.error;

public enum NamesErrorMessage {
    NULL_NAME("공백의 이름이 존재합니다. 올바르게 입력해 주세요"),
    LENGTH_EXCEEDED("최대 5자까지 입력 가능합니다."),
    REQUIRED_PLAYER("2대 이상의 자동차가 필요합니다."),
    DUPLICATE_NAME("이름은 중복될 수 없습니다."),
    INVALID_NAME("이름은 문자나 숫자만 허용됩니다");

    private final String message;

    NamesErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
