package racingcar.exception;

public class ExceptionHandler {

    public static void throwIllegalArgException(ErrorCode error) {
        throw new IllegalArgumentException(error.getMessage());
    }
}