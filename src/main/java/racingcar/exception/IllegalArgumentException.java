package racingcar.exception;

public class IllegalArgumentException extends RuntimeException{

    public IllegalArgumentException(ErrorMessage message) {
        super(message.getMessage());
    }
}
