package racingcar.message;

public enum ErrorMessage {
    NAME_TOO_LONG("자동차 이름이 6자 이상입니다."),
    DUPLICATE_NAME("중복된 자동차 이름이 있습니다."),
    EMPTY_NAME("자동차 이름을 입력하지 않았습니다."),
    NAME_IS_BLANK("자동차 이름에 공백이 있습니다."),
    INVALID_CHARACTER_IN_NAME("자동차 이름에 특수 문자가 포함되어 있습니다."),
    INVALID_ROUND_COUNT("라운드 수는 양의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
