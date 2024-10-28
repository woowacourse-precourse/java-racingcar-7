package racingcar.exception;

public class CarNameEmptyException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "이름은 비어있을 수 없습니다.";

    public CarNameEmptyException() {
        super(DEFAULT_MESSAGE);
    }
}
