package racingcar.exception;

public class NonPositiveNumberException extends IllegalArgumentException {

    public NonPositiveNumberException() {
        super();
    }

    public NonPositiveNumberException(String s) {
        super(s);
    }
}
