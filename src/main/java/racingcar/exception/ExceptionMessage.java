package racingcar.exception;

public enum ExceptionMessage {
    MAX_LENGTH_EXCEEDED("이름의 길이는 5를 넘을 수 없습니다."),
    DELIMITER_NOT_VALID("구분자를 바르게 입력해주세요."),
    DUPLICATE_NAME_NOT_ALLOWED("중복된 이름은 입력할 수 없습니다."),
    INVALID_BLANK_INPUT("공백만 입력할 수 없습니다."),
    INVALID_COUNT_FORMAT("시도횟수는 숫자로 입력해 주세요."),
    MAX_COUNT_LENGTH_EXCEEDED("시도횟수는 9,223,372,036,854,775,807를 넘을 수 없습니다."),
    INVALID_NON_POSITIVE_COUNT("시도횟수는 양수로 입력해주세요")
    ;

    private final String message;

    ExceptionMessage(String message) {this.message = message;}
    public String getMessage(){return message;}
}
