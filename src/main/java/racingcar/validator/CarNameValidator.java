package racingcar.validator;

import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_MAX_LENGTH;
import static racingcar.validator.ErrorMessages.INVALID_CAR_NAME_MIN_LENGTH;

public class CarNameValidator {

    public static void validateCarName(String carName) {
        validateMinNameLength(carName);
        validateMaxNameLength(carName);
    }

    private static void validateMaxNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MAX_LENGTH.getMessage());
        }
    }

    private static void validateMinNameLength(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MIN_LENGTH.getMessage());
        }
    }

}
