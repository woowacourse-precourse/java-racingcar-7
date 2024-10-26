package racingcar.exception;

import static racingcar.exception.ErrorMessage.*;

public class RacingGameException {

    public static class DuplicatedCarNameException extends IllegalArgumentException {
        public DuplicatedCarNameException() {
            super(DUPLICATED_CAR_NAME.getMessage());
        }
    }

    public static class BlankCarNameException extends IllegalArgumentException {
        public BlankCarNameException() {
            super(NOT_ALLOW_BLANK.getMessage());
        }
    }

    public static class CarNameEmptyInputException extends IllegalArgumentException {
        public CarNameEmptyInputException() {
            super(CAR_NAME_NOT_ALLOW_EMPTY.getMessage());
        }
    }

    public static class TryNumberEmptyInputException extends IllegalArgumentException {
        public TryNumberEmptyInputException() {
            super(CAR_NAME_NOT_ALLOW_EMPTY.getMessage());
        }
    }

    public static class InvalidNameLengthException extends IllegalArgumentException {
        public InvalidNameLengthException() {
            super(INVALID_NAME_LENGTH.getMessage());
        }
    }

    public static class NotNumericException extends IllegalArgumentException {
        public NotNumericException() {
            super(NOT_NUMERIC.getMessage());
        }
    }

    public static class NotPositiveNumberException extends IllegalArgumentException {
        public NotPositiveNumberException() {
            super(ONLY_NATURAL_NUMBER.getMessage());
        }
    }
}
