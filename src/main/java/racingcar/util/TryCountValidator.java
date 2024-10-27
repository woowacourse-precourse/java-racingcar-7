package racingcar.util;

import java.util.regex.Pattern;

public class TryCountValidator {

    private static final Pattern POSITIVE_INTEGER = Pattern.compile("^[1-9]\\d*$");

    public static boolean isPositiveNumber(String tryCount) {
        return POSITIVE_INTEGER.matcher(tryCount).matches();
    }
}
