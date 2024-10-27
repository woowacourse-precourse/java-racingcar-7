package constant;

public enum ErrorValidators {
    NAME_EMPTY("자동차 이름은 비어 있을 수 없습니다."),
    NAME_LONGER("자동차 이름은 5글자를 넘을 수 없습니다."),
    NAME_OVERLAP("자동차 이름이 중복 되었습니다 : ");

    ErrorValidators(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private final String message;
}
