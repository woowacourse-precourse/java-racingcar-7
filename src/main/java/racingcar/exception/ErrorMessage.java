package racingcar.exception;

public enum ErrorMessage {

    DUPLICATE_CAR_NAME("자동차 이름이 중복입니다."),
    COMMA_NOT_EXIST("자동차 이름은 쉼표(,)를 기준으로 구분해야 합니다."),
    EMPTY_CAR_NAMES("자동차 이름을 입력해주세요."),
    LONG_CAR_NAME("이름은 5자 이하만 가능합니다."),

    EMPTY_TRY_NUMBER("시도 횟수를 입력해주세요."),
    WRONG_NUMBER_FORMAT("잘못된 입력입니다. 숫자를 입력해주세요."),
    ZERO_TRY_NUMBER("시도 횟수는 0이 될 수 없습니다."),
    NEGATIVE_PATTERN("시도 횟수는 음수일 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
