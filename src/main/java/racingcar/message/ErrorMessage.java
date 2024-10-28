package racingcar.message;

public class ErrorMessage {

    private ErrorMessage() {
    }

    public static String INPUT_BLANK = "빈 값을 입력했습니다.";
    public static String INPUT_NOT_INTEGER = "숫자를 입력해야합니다.";
    public static String INVALID_CAR_NAME = "자동차 이름은 5자 이하여야 합니다.";
    public static String INVALID_NEGATIVE = "0보다 작은 값을 입력할 수 없습니다.";
}