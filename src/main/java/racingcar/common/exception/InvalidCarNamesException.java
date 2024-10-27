package racingcar.common.exception;

public class InvalidCarNamesException extends IllegalArgumentException{
    public InvalidCarNamesException() {
        super(ErrorMessage.INVALID_CAR_NAMES.getDescription());
    }
}
