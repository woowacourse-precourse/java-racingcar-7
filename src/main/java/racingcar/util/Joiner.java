package racingcar.util;

import java.util.List;

public class Joiner {

    private static final String BLANK = " ";

    public static String join(String delimiter, List<String> strings) {
        return String.join(delimiter, strings);
    }

}
