package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class ParseStringUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";

    public static List<String> parseCarNames(String input) {
        ValidateUtil.validateCar(input);
        return Arrays.stream(input.split(SPLIT_REGEX_PREFIX)).toList();
    }

    public static int parseAttemptCount(String attemptCount) {
        ValidateUtil.validateAttemptCount(attemptCount);
        return Integer.parseInt(attemptCount);
    }

}
