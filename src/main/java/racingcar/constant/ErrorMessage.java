package racingcar.constant;

public class ErrorMessage {
    public static final String CAR_NAME_LENGTH_ERROR = "이름의 길이는 1자 이상 5자 이하여야 합니다.";
    public static final String MINIMUM_ROUND_ERROR = "시도 횟수는 1미만이면 안됩니다.";
    public static final String NO_PARTICIPANTS_ERROR = "참가자가 없습니다.";
    public static final String INVALID_INPUT_TYPE_ERROR = "잘못된 타입입니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR = "중복된 이름입니다.";

    private ErrorMessage() {
    }
}
