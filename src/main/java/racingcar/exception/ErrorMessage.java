package racingcar.exception;


public enum ErrorMessage {

    LONG_NAME("이름 5자 초과"),
    INPUT_NOT_BLANK("입력 공백"),
    NOT_NUM("숫자 변환 실패"),
    EXIST_NAME("이미 존재하는 이름"),
    NOT_ENGLISH("영어 이름이 아님"),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
