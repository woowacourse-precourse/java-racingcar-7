package racingcar.validator;

import racingcar.exception.InvalidCarNameException;

public class CarNameValidator {
    public static void validate(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > 5) {
            throw new InvalidCarNameException();
        }
    }
}
