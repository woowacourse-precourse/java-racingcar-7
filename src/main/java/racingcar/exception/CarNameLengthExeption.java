package racingcar.exception;

public class CarNameLengthExeption extends IllegalArgumentException {
    public CarNameLengthExeption(String message) {
        super(message);
    }
}
