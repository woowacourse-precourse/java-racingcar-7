package racingcar.common.util;

import java.util.List;

public class StringUtil {
    private static final String COMMA = ", ";

    public static String joinWithComma(List<String> items) {
        return String.join(COMMA, items);
    }
}
