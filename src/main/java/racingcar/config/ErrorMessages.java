package racingcar.config;

public enum ErrorMessages {
    EMPTY_INPUT("자동차 이름을 반드시 입력해야 합니다."),
    INVALID_NAME("잘못된 입력입니다. 자동차 이름은 1~5자 사이의 유효한 문자로 구성되어야 합니다."),
    EMPTY_ROUND_COUNT("라운드 횟수를 반드시 입력해야 합니다."),
    INVALID_ROUND_COUNT("라운드 횟수는 1 이상의 숫자여야 합니다."),
    INVALID_NUMBER_FORMAT("올바른 숫자를 입력해야 합니다."),
    DUPLICATE_NAME("자동차 이름에 중복이 있습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
