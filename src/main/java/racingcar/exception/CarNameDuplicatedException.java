package racingcar.exception;

public class CarNameDuplicatedException extends RuntimeException {

    private static final String message = "중복되는 자동차 이름이 존재합니다.";

    public CarNameDuplicatedException() {
        super(message);
    }
}
