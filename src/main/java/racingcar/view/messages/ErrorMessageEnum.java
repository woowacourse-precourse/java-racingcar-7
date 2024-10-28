package racingcar.view.messages;

public enum ErrorMessageEnum {
    EMPTY_ERROR("[ERROR] 입력이 비어있습니다."),
    DUPLICATE_NAMES_ERROR("[ERROR] 중복된 이름이 입력되었습니다."),
    NOT_NATURAL_NUMBER_ERROR("[ERROR] 시도 횟수는 자연수여야 합니다."),
    NAME_LENGTH_ERROR("[ERROR] 이름 길이는 5자 이하만 가능합나다.");

    private final String message;

    ErrorMessageEnum(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
