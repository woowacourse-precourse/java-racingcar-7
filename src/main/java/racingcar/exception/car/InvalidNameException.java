package racingcar.exception.car;

public class InvalidNameException extends IllegalArgumentException {
    public InvalidNameException(final String s) {
        super(s);
    }
}
