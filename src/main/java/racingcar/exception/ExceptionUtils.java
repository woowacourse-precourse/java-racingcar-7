package racingcar.exception;

public class ExceptionUtils {
    public static void throwIllegalArgException(CarNameValidationError error) {
        throw new IllegalArgumentException(error.getMessage());
    }
}
