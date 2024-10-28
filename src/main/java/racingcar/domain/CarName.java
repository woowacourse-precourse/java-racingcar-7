package racingcar.domain;

import static racingcar.utils.Constant.MAX_CAR_NAME_LEN;
import static racingcar.utils.ErrorMessage.INVALID_CAR_NAME;

public class CarName {

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName create(String value) {
        return new CarName(validName(value));
    }

    protected static String validName(String name) {
        if (name == null || isInvalidName(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.getMessage());
        }

        return name;
    }

    private static boolean isInvalidName(String name) {
        int length = name.length();

        return length == 0 || length > MAX_CAR_NAME_LEN;
    }


    @Override
    public String toString() {
        return name;
    }
}
