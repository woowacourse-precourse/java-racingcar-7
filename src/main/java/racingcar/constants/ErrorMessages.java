package racingcar.constants;

public enum ErrorMessages {
    INVALID_TRY_NUMBER("시도 횟수는 숫자만 입력이 가능합니다."),
    EXCEED_CAR_NAME_LIMIT("자동차의 이름은 5자 이하만 가능합니다."),
    INVALID_DELIMITER("구분자는 쉼표만 가능합니다.")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
