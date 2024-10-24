package racingcar.view.messages;

public enum ErrorMessageEnum {
    _ERROR("[ERROR] 니다.");

    private final String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
