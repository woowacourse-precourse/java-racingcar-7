package racingcar.message;

public enum ErrorMessage {
    /*
    공통 에러
     */
    COMMON_INPUT_BLANK_ERROR("공백 값은 허용하지 않습니다."),
    /*
    시도 횟수 관련 에러
     */
    TRY_NUM_NOT_NUMERIC_ERROR("시도 횟수는 0-9 사이의 정수만 허용됩니다."),

    ;


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
