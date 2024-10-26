package racingcar.constant;

public enum ExceptionMessage {
    CAR_NAME_DELIMITER_ERROR("쉼표가 아닌 문자표가 있습니다."),
    CAR_NAME_EMPTY_ERROR("자동차의 이름 중 공백이 있습니다."),
    CAR_NAME_NO_INPUT_ERROR("자동차의 이름이 입력되지 않았습니다."),
    NOT_POSITIVE_INTEGER("양의 정수를 입력해주세요."),
    WRONG_FORMAT("출력 형식이 잘못되었습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
