package racingcar.front.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.front.exception.DuplicatedCarNamesException;
import racingcar.front.exception.InvalidCarNameInputException;

public class CommaDelimiterParser {
    private static final Pattern INPUT_FORMAT = Pattern.compile("^[^,\\s]{1,5}(?:,[^,\\s]{1,5})*$");
    private static final String COMMA = ",";

    public static List<String> parse(String carNames) {
        if (INPUT_FORMAT.matcher(carNames).matches() == false) {
            throw new InvalidCarNameInputException();
        }

        String[] split = carNames.split(COMMA);
        Set<String> nonDuplicatedCarNames = Arrays.stream(split).collect(Collectors.toSet());
        if (nonDuplicatedCarNames.size() < split.length) {
            throw new DuplicatedCarNamesException();
        }

        return Arrays.stream(split).toList();
    }
}
