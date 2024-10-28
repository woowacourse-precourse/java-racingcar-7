package racingcar.util;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {

    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> splitCarNames() {

    }

    private static void validateCarName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[error] 자동차 이름은 1~5자");
        }

    }
}
