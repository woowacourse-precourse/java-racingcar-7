package racingcar;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<String> splitInputStringsByComma(String carNames) {
        return Arrays.asList(carNames.split(","));
    }
}
