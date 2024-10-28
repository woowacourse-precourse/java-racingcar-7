package racingcar.message;

public enum ErrorMessage {

    BLANK_INPUT_ERROR("[ERROR] 빈 문자열을 입력하실 수 없습니다."),
    CONTAINS_SPACE_ERROR("[ERROR] 문자열은 띄어쓰기를 포함할 수 없습니다."),
    NAME_LENGTH_ERROR("[ERROR] 이름의 길이는 한글자 이상, 5글자 이하여야 합니다."),
    NAME_DUPLICATE_ERROR("[ERROR] 이름은 중복될 수 없습니다."),
    INVALID_NUMBER_ERROR("[ERROR] 시도 횟수는 정수여야 합니다."),
    NEGATIVE_NUMBER_ERROR("[ERROR] 시도 횟수는 0 이상의 정수여야 합니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
