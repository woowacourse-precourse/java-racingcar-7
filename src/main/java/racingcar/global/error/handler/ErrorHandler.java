package racingcar.global.error.handler;

public class ErrorHandler {

    public static void handlerError(String errorMessage) {
        throw new IllegalArgumentException("경고 : " + errorMessage);
    }

}
