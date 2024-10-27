package racingcar.exception;

public class CustomException extends IllegalArgumentException {

    public CustomException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
