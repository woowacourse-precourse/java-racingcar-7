package racingcar.exception;

public class CustomException extends IllegalArgumentException{

    ExceptionCode code;

    public CustomException(final ExceptionCode code) {
        super(code.message);
        this.code = code;
    }
}
