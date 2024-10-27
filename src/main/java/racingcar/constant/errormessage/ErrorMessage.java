package racingcar.constant.errormessage;

public class ErrorMessage {
    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String WITHIN_RANGE_ERROR_MESSAGE = ERROR_MESSAGE + "이름 길이가 5초과입니다";
    public static final String REGEX_ERROR = ERROR_MESSAGE + "입력 형식이 잘못되었습니다";
    public static final String DUPLICATE_ERROR = ERROR_MESSAGE + "중복된 값이 있습니다";
    public static final String UNEXPECTED_ERROR = ERROR_MESSAGE + "예상치 못한 에러 발생";
    public static final String INTEGER_MAX_VALUE_ERROR = ERROR_MESSAGE + "정수형 최대 범위를 넘었습니다";
}
