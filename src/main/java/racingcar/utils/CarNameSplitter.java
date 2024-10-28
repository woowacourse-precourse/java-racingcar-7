package racingcar.utils;

import java.util.Arrays;
import java.util.List;

public class CarNameSplitter {
    private static final String CAR_NAME_DELIMITER = ",";

    private CarNameSplitter() {
    }

    public static List<String> separateCarNames(String names) {
        return Arrays.asList(names.split(CAR_NAME_DELIMITER));
    }
}