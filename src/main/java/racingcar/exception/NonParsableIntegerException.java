package racingcar.exception;

public class NonParsableIntegerException extends IllegalArgumentException {

    static final String DEFAULT_MESSAGE = "int형으로 변환할 수 없습니다.";

    public NonParsableIntegerException() {
        super(DEFAULT_MESSAGE);
    }
}
