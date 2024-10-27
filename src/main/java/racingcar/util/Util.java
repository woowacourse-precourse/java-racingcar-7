package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> splitByComma(String string) {
        return Arrays.stream(string.split(",")).toList();
    }
}
