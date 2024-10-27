package racingcar;

public class ErrorMessage {
    public static final String INPUT_IS_EMPTY = "입력값이 비어있습니다.";
    public static final String ONLY_COMMA_HERE = "쉼표만 입력되었습니다.";
    public static final String INCORRECT_TYPE_COMMA_N_NAME = "쉼표 뒤에 이름이 들어오지 않았습니다.";
    public static final String OVER_5_LENGTH = "이름이 5자를 초과합니다.";
    public static final String DUPLICATE_NAME = "중복된 이름이 존재합니다.";
    public static final String BE_NATURAL_NUMBER = "입력값은 1 이상의 자연수여야 합니다.";
    public static final String BE_DIGIT = "입력값은 숫자여야 합니다.";

    private ErrorMessage() {

    }
}
