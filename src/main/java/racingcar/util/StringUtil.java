package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {
    public static String[] splitByComma(String input) {
        return input.split(",");
    }

    public static ArrayList<String> toArrayList(String[] strings) {
        return new ArrayList<>(Arrays.asList(strings));
    }
}
