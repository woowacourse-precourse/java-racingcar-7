package racingcar.validator;

public enum ValidationMessage {
    INVALID_CAR_NAMES_INPUT("자동차 이름을 2개 이상 입력해주세요."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_DELIMITER("자동차 이름은 쉼표(,)를 기준으로 구분합니다."),
    DUPLICATE_CAR_NAMES("중복된 자동차 이름이 입력되었습니다.");

    private final String message;

    ValidationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}