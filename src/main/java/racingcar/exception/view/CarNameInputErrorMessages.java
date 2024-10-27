package racingcar.exception.view;

public enum CarNameInputErrorMessages {
    INPUT_IS_EMPTY("자동차 이름 입력을 빈 문자열로 입력할 수 없습니다."),
    CAR_NAME_INVALID_LENGTH("자동차 이름은 1자 이상, 5자 이하이어야 합니다."),
    CAR_NAME_NOT_LOWERCASE("자동차 이름은 소문자 영어로만 이루어져야 합니다."),
    INPUT_CONTAINS_WHITESPACE("자동차 이름에는 공백이 포함될 수 없습니다."),
    CAR_NAME_DUPLICATE("중복된 자동차 이름이 있습니다."),
    INPUT_CONTAINS_INVALID_DELIMITER("자동차 이름은 쉼표(,)로만 구분되어야 합니다.");

    private final String message;

    CarNameInputErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
