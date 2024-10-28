package racingcar.exception;

public class CarNameOverLengthLimitException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE ="자동차의 이름은 5자 이하여야 합니다.";

    public CarNameOverLengthLimitException() {
        super(ERROR_MESSAGE);
    }
}
