package racingcar.validation;

import racingcar.exception.RacingExceptionStatus;


public class CarNameValidation {

    public static void validate(String carName) {
        checkCarNameLength(carName);
        checkCarNameBlank(carName);
    }

    private static void checkCarNameLength(String carName) {
        if (carName.trim().length() > 5) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static void checkCarNameBlank(String carName) {
        if (carName.equals(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage());
        }
    }
}
