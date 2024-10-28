package racingcar;

public enum ErrorMessages {
    EMPTY_CAR_NAMES("자동차 이름은 비어있을 수 없습니다."),
    WHITE_SPACE_INPUT("입력에 공백이 포함되어 있습니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하여야 합니다."),
    DUPLICATE_CAR_NAMES("중복된 자동차 이름이 존재합니다."),
    INVALID_MAX_ROUND("라운드는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
