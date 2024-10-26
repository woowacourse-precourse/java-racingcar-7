package view.message;

public enum ErrorMessage {
    EMPTY_MESSAGE("입력 값이 존재하지 않습니다."),
    SHAPE_MESSAGE("입력 형태가 올바르지 않습니다."),
    CAR_NAME_LENGTH_MESSAGE("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    EXIST_CAR_NAME_MESSAGE("중복된 자동차 이름이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
