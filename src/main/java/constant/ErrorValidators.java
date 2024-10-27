package constant;

public enum ErrorValidators {
    NAME_EMPTY("자동차 이름은 비어 있을 수 없습니다."),
    NAME_LONGER("자동차 이름은 5글자를 넘을 수 없습니다."),
    NAME_OVERLAP("자동차 이름이 중복 되었습니다 : "),
    COUNT_ERROR_MESSAGE("횟수는 0 이상이어야 합니다."),
    COUNT_INPUT_STRING_ERROR_MESSAGE("숫자를 입력해주세요."),
    COUNT_EMPTY_MESSAGE("입력이 필요합니다.");

    ErrorValidators(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;

}
