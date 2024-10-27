package racingcar.exception;

public class CarNameLengthException extends IllegalArgumentException {

    public CarNameLengthException() {
        super("자동차 이름은 5자 이하여야 합니다.");
    }
}
