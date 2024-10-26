package racingcar.exception;

import racingcar.validation.CarNameValidation;

public class CarException {
    public static void nameException(String carName) {
        if (CarNameValidation.validateCarNameLength(carName)) {
            throw new CarNameLengthException();
        }
    }
}
