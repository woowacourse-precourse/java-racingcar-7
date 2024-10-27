package racingcar.exception;

public class ExceptionHandler {
    public static void handleIllegalArgumentException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        throw e;
    }
}