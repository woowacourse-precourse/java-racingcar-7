package racingcar.exception;

public enum GameErrorMessage {
    INPUT_EMPTY("입력 값은 문자가 존재해야합니다."),
    CAR_NAME_EXISTS_AND_LIMIT_ERROR("자동차의 이름은 존재해야하며 5자 이하만 가능합니다."),
    TRY_COUNT_LITTLE_ONE("시도 횟수는 0보다 커야됩니다."),
    CAR_NAME_DUPLICATED("중복된 자동차 이름이 존재합니다. 자동차 이름은 중복되면 안됩니다."),
    WRONG_TYPE_TRY_COUNT("잘못된 형태의 시도 횟수입니다.");

    private final String message;

    GameErrorMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
