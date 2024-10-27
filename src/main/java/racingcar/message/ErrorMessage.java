package racingcar.message;

public enum ErrorMessage {
    /*
    공통
     */
    COMMON_INPUT_BLANK_ERROR("공백 값은 허용하지 않습니다."),
    /*
    시도 횟수 관련 에러
     */
    TRY_NUM_NOT_NUMERIC_ERROR("시도 횟수는 0-9 사이의 정수만 허용됩니다."),
    /*
    차 이름 관련 에러
     */
    CAR_NAME_SEPARATOR_ERROR("입력에 구분자 ,를 포함해주세요."),
    CAR_NAME_NOT_DUPLICATE_ERROR("차 이름은 중복될 수 없습니다."),
    CAR_NAME_LENGTH_EXCEEDED_ERROR("이름이 5자 이상일 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
