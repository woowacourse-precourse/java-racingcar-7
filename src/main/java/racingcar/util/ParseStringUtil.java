package racingcar.util;

import racingcar.exception.RaceException;

import java.util.Arrays;
import java.util.List;

public class ParseStringUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";
    private static final String SPACING_PREFIX = " ";

    public static List<String> parseCarNames(String input) {
        if (input.contains(SPACING_PREFIX))
            throw new IllegalArgumentException(RaceException.SPACING_NOT_ALLOWED.getDescription());
        return Arrays.stream(input.split(SPLIT_REGEX_PREFIX)).toList();
    }
}
