package racingcar.global.util;

import static racingcar.global.constant.Config.MAX_CAR_NAME_SIZE;
import static racingcar.global.constant.ErrorMessage.CAR_NAME_OVERSIZE_MESSAGE;

public class Validator {

    public static void ValidateCarName(String name) {
        ValidateCarNameSize(name);
    }

    private static void ValidateCarNameSize(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_OVERSIZE_MESSAGE);
        }
    }
}
