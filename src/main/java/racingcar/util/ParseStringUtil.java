package racingcar.util;

import racingcar.exception.RaceException;

import java.util.Arrays;
import java.util.List;

public class ParseStringUtil {
    private static final String SPLIT_REGEX_PREFIX = ",";
    private static final String SPACING_PREFIX = " ";

    public static List<String> parseCarNames(String input) {
        validate(input);
        return Arrays.stream(input.split(SPLIT_REGEX_PREFIX)).toList();
    }

    private static void validate(String input) {
        if (input.isBlank())
            throw new IllegalArgumentException(RaceException.INPUT_VALUE_EMPTY.getDescription());

        if (input.contains(SPACING_PREFIX))
            throw new IllegalArgumentException(RaceException.SPACING_NOT_ALLOWED.getDescription());

        if (!input.contains(SPLIT_REGEX_PREFIX))
            throw new IllegalArgumentException(RaceException.ARGUMENT_SIZE_UNSATISFIED.getDescription());
    }
}
