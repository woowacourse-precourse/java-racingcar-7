package racingcar.exception;

import static racingcar.validator.Validator.MAX_COUNT_LIMIT_OF_CAR;

public class CarCountOutOfBoundsException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = String.format("한 번에 경주할 수 있는 차는 최대 %s대입니다.", MAX_COUNT_LIMIT_OF_CAR);


    public CarCountOutOfBoundsException() {
        super(ERROR_MESSAGE);
    }
}
