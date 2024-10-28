package racingcar.exceptions;

public class CarNameException extends IllegalArgumentException {
    public CarNameException() {
        super("중복된 이름은 허용하지 않습니다.");
    }
}
