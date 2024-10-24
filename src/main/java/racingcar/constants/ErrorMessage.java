package racingcar.constants;

public class ErrorMessage {
    public static final String NOT_ALLOWED_FIRST_LAST_BLANK = "문장 맨 앞, 맨 뒤에는 공백이 포함 되지 않아야 합니다.";
    private static final String MIN_CAR_NAME_LENGTH = "1";
    private static final String MAX_CAR_NAME_LENGTH = "5";
    public static final String NOT_ALLOWED_CAR_NAME_LENGTH = "자동차 이름은 " + MIN_CAR_NAME_LENGTH + "자 이상, "
            + MAX_CAR_NAME_LENGTH + " 자 이하여야 합니다.";
}
