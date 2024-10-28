package racingcar.exception;

public class CarRacingException extends IllegalArgumentException {

    public CarRacingException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
