package racingcar.domain.util;

import racingcar.infrastructure.exception.EmptyInputException;
import racingcar.domain.model.constant.CarNameDelimiter;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public static List<String> parse(final String input) {
        List<String> parsed = parseWithTrim(input, CarNameDelimiter.getRegex());
        validateExistEmpty(parsed);
        return parsed;
    }

    private static void validateExistEmpty(final List<String> list) {
        if (list.stream().anyMatch(String::isEmpty)) {
            throw new EmptyInputException();
        }
    }

    private static List<String> parseWithTrim(final String input, final String regex) {
        return Arrays.stream(input.split(regex))
                .map(String::trim)
                .toList();
    }
}
