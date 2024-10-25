package racingcar.front.parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.front.exception.InvalidCarNameInputException;

public class CommaDelimiterParser {
    private static final Pattern INPUT_FORMAT = Pattern.compile("^[^,]{1,5}(?:,[^,]{1,5})*$");
    private static final String COMMA = ",";

    public static List<String> parse(String carNames) {
        if (INPUT_FORMAT.matcher(carNames).matches() == false) {
            throw new InvalidCarNameInputException();
        }

        String[] split = carNames.split(COMMA);
        return Arrays.stream(split).toList();
    }
}
