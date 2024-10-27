package racingcar.model;

public enum ErrorType {

    INPUT_NULL_ERROR("[ERROR] 빈 문자열은 입력할 수 없습니다."),
    CAR_NAME_LENGTH_ERROR("[ERROR] 이름은 5자 이하여야 합니다."),
    GAME_TRY_COUNT_ERROR("[ERROR] 입력 횟수는 1회 이상이여야 합니다."),
    CAR_NAME_DUPLICATE_ERROR("[ERROR] 중복된 이름이 있습니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
