package racingcar.exception;

public class BaseException extends IllegalArgumentException {

    private final ExceptionMessage exceptionMessage;

    public BaseException(ExceptionMessage exceptionMessage) {
        super(exceptionMessage.message());
        this.exceptionMessage = exceptionMessage;
    }
}
