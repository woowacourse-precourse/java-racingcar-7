package racingcar.common.utils;

import java.util.List;
import java.util.stream.Stream;
import racingcar.common.exception.InvalidInputException;

public class StringSplitter {

    private static final String COMMA = ",";
    private static final String DELIMITED_STRING_PATTERN = "^[^%s]+(%s[^%s]+)*$";

    private StringSplitter() {
    }

    public static List<String> splitByComma(final String target) {
        return split(target, COMMA);
    }

    public static List<String> split(final String target, final String delimiter) {
        validate(target, delimiter);
        return Stream.of(target.split(delimiter))
                .map(String::trim)
                .toList();
    }

    private static void validate(final String target, final String delimiter) {
        checkNullOrEmpty(target);
        checkDelimitedPattern(target, delimiter);
    }

    private static void checkNullOrEmpty(final String target) {
        if (target == null || target.isBlank()) {
            throw InvalidInputException.forInvalidInput();
        }
    }

    private static void checkDelimitedPattern(final String target, final String delimiter) {
        String pattern = String.format(DELIMITED_STRING_PATTERN, delimiter, delimiter, delimiter);
        if (!target.matches(pattern)) {
            throw InvalidInputException.forInvalidInput();
        }
    }
}