package racingcar.exception;

public class CarNameContainsWhiteSpaceException extends IllegalArgumentException {

    public CarNameContainsWhiteSpaceException() {
        super("자동차 이름에 공백이 포함될 수 없습니다.");
    }
}
