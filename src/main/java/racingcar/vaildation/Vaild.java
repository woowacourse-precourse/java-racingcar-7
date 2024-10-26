package racingcar.vaildation;

import racingcar.constants.Constants;

public class Vaild {

    public static void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(Constants.NAME_EMPTY_ERROR);
        }
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_ERROR);
        }
    }
}
