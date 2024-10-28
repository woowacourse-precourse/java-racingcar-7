package racingcar.validator;

import racingcar.constants.ValidationConstants;

public class CarNameValidator {

    public void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ValidationConstants.CAR_NAME_LENGTH_EXCEEDED + carName);
        }
    }

    public void validateCarNameIsEmpty(String inputCarsName) {
        if (inputCarsName == null || inputCarsName.trim().isEmpty()) {
            throw new IllegalArgumentException(ValidationConstants.CAR_NAME_EMPTY);
        }
    }
}
