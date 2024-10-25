package racingcar.util;

import java.util.List;

public class CommonUtil {

    public static List<String> splitToList(String input, String delimiter) {
        return List.of(input.split(delimiter));
    }
}
