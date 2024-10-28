package racingcar.exception;


import racingcar.console.OutputView;

public class ExceptionHandler {
    public static void handleException(Exception e) {
        OutputView.printError(e.getMessage());
    }
}