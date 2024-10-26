package racingcar.app.server.exception;

public class BusinessException extends IllegalArgumentException {
    public BusinessException(String message) {
        super(message);
    }
}
