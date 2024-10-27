package racingcar.validator;

import racingcar.message.ErrorMessage;

public class CarNameValidator {

    private final static int NAME_LENGTH = 5;

    public static void validateCarName(String carName) {
        validateCarNameFormat(carName);
        validateCarNameLength(carName);
    }

    public static void validateCarNameFormat(String carName) {
        if (!carName.matches("^[a-zA-Z]+")) {
            throw new IllegalArgumentException(ErrorMessage.NON_ALPHA_MESSAGE);
        }
    }

    public static void validateCarNameLength(String carName) {
        if (carName.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_MESSAGE);
        }
    }
}
