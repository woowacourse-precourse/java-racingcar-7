package racingcar.exception;

public class RacingException {

    public static void throwIllegalArgumentException(String message) {
        throw new IllegalArgumentException(message);
    }

    public static void throwIllegalArgumentException(String message, boolean flag) {
        if (flag) {
            throw new IllegalArgumentException(message);
        }
    }

}
