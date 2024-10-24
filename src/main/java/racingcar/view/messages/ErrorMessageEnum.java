package racingcar.view.messages;

public enum ErrorMessageEnum {
    EMPTY_ERROR("[ERROR] 입력이 비어있습니다."),
    DUPLICATE_NAMES_ERROR("[ERROR] 중복된 이름이 입력되었습니다."),
    NOT_NATURAL_NUMVER_ERROR("[ERROR] 시도 횟수는 자연수여야 합니다.");

    private final String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
