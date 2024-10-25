package racingcar.utils.validation;

import racingcar.exception.RacingExceptionStatus;

public class CarNameValidation {

    public static void validate(String carName) {
        checkCarNameBlank(carName);
        checkCarNameLength(carName);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static void checkCarNameBlank(String carName) {
        if (carName.equals(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage());
        }
    }
}
