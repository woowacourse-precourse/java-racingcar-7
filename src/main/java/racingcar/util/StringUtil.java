package racingcar.util;

import java.util.List;


public class StringUtil {
    public static List<String> splitCarName(String carNames) {
        return List.of(carNames.split(","));
    }
}
