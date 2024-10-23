package racingcar.constants;

public enum ErrorMessages {
    INVALID_DELIMITER("구분자는 쉼표만 가능합니다."),
    NO_EXIST_TRY_NUMBER("시도 횟수를 입력해주세요."),
    NO_EXIST_CAR_NAME("자동차의 이름을 입력해주세요."),
    NEGATIVE_TRY_NUMBER("시도 횟수는 양수만 가능합니다."),
    INVALID_TRY_NUMBER("시도 횟수는 숫자만 입력이 가능합니다."),
    EXCEED_CAR_NAME_LIMIT("자동차의 이름은 5자 이하만 가능합니다.")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
