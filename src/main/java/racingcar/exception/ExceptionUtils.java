package racingcar.exception;

public class ExceptionUtils {
    public static void throwIllegalArgException(ErrorMessage error) {
        throw new IllegalArgumentException(error.getMessage());
    }
}
