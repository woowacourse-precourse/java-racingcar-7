package racingcar.validator;


import static racingcar.error.ErrorMessageConstants.CAR_NAME_TOO_LONG;
import static racingcar.error.ErrorMessageConstants.INVALID_CAR_NAME;

public class CarValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG);
        }
    }
}