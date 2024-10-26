package racingcar.server.error;

public class ErrorMessage {

    public static String SHOULD_NOT_BE_NULL = "[ERROR] NULL이여서는 안됩니다.";
    public static String LAP_COUNT_SHOULD_NOT_BE_MINUS = "[ERROR] 남은 Lap의 수는 0보다 크거나 같아야 합니다.";
    public static String DISTANCE_SHOULD_NOT_BE_MINUS = "[ERROR] 남은 거리는 0보다 크거나 같아야 합니다.";

    private ErrorMessage() {
    }
}
