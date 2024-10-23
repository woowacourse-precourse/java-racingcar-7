package racingcar.common;

import java.util.regex.Pattern;

public class RegexUtils {
    private static final String SPECIAL_CHAR_CHECK_REGEX = "^[a-zA-Z0-9,]+$";
    private static final String NUMBER_CHECK_REGEX = "^[0-9]+$";

    public static boolean isContainSpecialChar(String input) {
        return Pattern.matches(SPECIAL_CHAR_CHECK_REGEX, input);
    }

    public static boolean isContainOnlyNumber(String input) {
        return Pattern.matches(NUMBER_CHECK_REGEX, input);
    }
}
