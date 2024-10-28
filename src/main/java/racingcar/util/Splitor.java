package racingcar.util;

import java.util.Arrays;
import java.util.List;

public abstract class Splitor {
    private static final String DELIMITER = ",";

    public static List<String> split(String carName) {
        return Arrays.stream(carName.split(DELIMITER)).toList();
    }
}
