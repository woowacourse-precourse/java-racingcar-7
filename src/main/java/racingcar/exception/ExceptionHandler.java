package racingcar.exception;

public class ExceptionHandler {
    public static void handleIllegalArgumentExeption(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}