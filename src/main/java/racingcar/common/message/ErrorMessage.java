package racingcar.common.message;

public class ErrorMessage {

    public static String SHOULD_NOT_BE_NULL = "[ERROR] NULL이여서는 안됩니다.";
    public static String LAP_COUNT_SHOULD_NOT_BE_MINUS = "[ERROR] 남은 Lap의 수는 0보다 크거나 같아야 합니다.";
    public static String DISTANCE_SHOULD_NOT_BE_MINUS = "[ERROR] 남은 거리는 0보다 크거나 같아야 합니다.";
    public static String EMPTY_INPUT = "[ERROR] 값을 입력하지 않으셨습니다.";
    public static String NOT_ENOUGH_CAR = "[ERROR] 최소 %d명 이상의 자동차가 입력되어야 합니다.";
    public static String CAR_NAME_LENGTH_EXCEED = "[ERROR] 자동차 이름은 %d글자를 넘을 수 없습니다.";
    public static String LOWER_THAN_ONE = "[ERROR] Lap 횟수는 0 보다 커야 합니다.";
    public static String UN_NECESSARY_CHAR_INCLUDED = "[ERROR] 숫자 외에 다른 문자는 입력하시면 안됩니다.";

    private ErrorMessage() {
    }
}
