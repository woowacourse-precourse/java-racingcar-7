package racingcar.ui;

public enum InputError {
    TRY_COUNT_MUST_BE_POSITIVE("시도횟수는 양수만 입력 가능합니다."),
    NAME_CANNOT_BE_BLANK("이름은 공백일 수 없습니다."),
    NAME_LENGTH_OVER("이름은 5자 이하만 가능합니다."),
    DUPLICATE_NAME("중복된 이름이 존재합니다.");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
