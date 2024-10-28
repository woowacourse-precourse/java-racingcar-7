package racingcar.exception;

public class CustomException extends IllegalArgumentException {

    private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        printErrorMessage();
    }

    private void printErrorMessage() {
        System.err.println(errorCode.getName());
    }
}
