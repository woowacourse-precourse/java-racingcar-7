package racingcar;

public class CustomException extends IllegalArgumentException{

    ExceptionCode code;

    public CustomException(ExceptionCode code) {
        super(code.message);
        this.code = code;
    }
}
