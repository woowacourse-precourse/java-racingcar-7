package racingcar.exception;

public class DuplicatedElementException extends IllegalArgumentException {

    public DuplicatedElementException() {
        super();
    }

    public DuplicatedElementException(String s) {
        super(s);
    }
}
