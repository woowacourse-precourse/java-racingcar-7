package racingcar.global.util;

import static racingcar.global.constant.Config.MAX_CAR_NAME_SIZE;
import static racingcar.global.constant.ErrorMessage.CAR_NAME_OVERSIZE_ERROR_MESSAGE;
import static racingcar.global.constant.ErrorMessage.MOVEMENT_NUMBER_FORMAT_ERROR_MESSAGE;

public class Validator {

    public static void ValidateCarName(String name) {
        ValidateCarNameSize(name);
    }

    private static void ValidateCarNameSize(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_OVERSIZE_ERROR_MESSAGE);
        }
    }

    public static void ValidateMovementNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(MOVEMENT_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
