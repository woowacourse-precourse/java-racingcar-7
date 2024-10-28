package racingcar.global.error;

public class ErrorHandler {

    public static void handlerError(String errorMessage) {
        throw new IllegalArgumentException("경고 : " + errorMessage);
    }

}
