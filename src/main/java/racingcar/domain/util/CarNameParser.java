package racingcar.domain.util;

import racingcar.infrastructure.exception.DuplicateNameException;
import racingcar.infrastructure.exception.EmptyInputException;
import racingcar.infrastructure.constant.CarNameDelimiter;

import java.util.*;

public class CarNameParser {
    public static List<String> parse(final String input) {
        List<String> parsed = parseWithTrim(input, CarNameDelimiter.getRegex());
        validateExistEmpty(parsed);
        validateExistDuplicate(parsed);
        return parsed;
    }

    private static void validateExistEmpty(final List<String> list) {
        if (list.stream().anyMatch(String::isEmpty)) {
            throw new EmptyInputException();
        }
    }

    private static void validateExistDuplicate(final List<String> list) {
        HashSet<String> duplicateRemoved = new HashSet<>(list);
        if (list.size() != duplicateRemoved.size()) {
            throw new DuplicateNameException();
        }
    }

    private static List<String> parseWithTrim(final String input, final String regex) {
        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .toList();
    }
}
