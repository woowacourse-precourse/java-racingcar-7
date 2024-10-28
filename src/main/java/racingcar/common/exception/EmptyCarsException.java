package racingcar.common.exception;

public class EmptyCarsException extends IllegalArgumentException {

    public EmptyCarsException() {
        super(ErrorMessage.CARS_EMPTY.getDescription());
    }
}
