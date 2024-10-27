package racingcar.constants;

public class ErrorMessages {
    private ErrorMessages() {
    }

    public static String OVER_LENGTH_ERROR_MESSAGE = "이름은 5글자를 넘길 수 없습니다";
    public static String UNDER_LENGTH_ERROR_MESSAGE = "이름은 최소 1글자 이상이어야 합니다";
    public static String CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE = "이름에는 특수문자가 들어갈 수 없습니다";
    public static String CONTAIN_BLANK_ERROR_MESSAGE = "이름에는 공백이 들어갈 수 없습니다";
    public static String NUMBER_FORMAT_ERROR_MESSAGE = "시도할 횟수는 숫자만 입력 가능합니다";
    public static String NAME_DUPLICATE_ERROR_MESSAGE = "중복된 이름이 있습니다";
}
