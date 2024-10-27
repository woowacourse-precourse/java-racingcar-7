package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public List<String> parseCarNameString(String input) {

        return Arrays.asList(input.split(","));
    }

    public int parseTryNumberString(String input) {
        return Integer.parseInt(input);
    }
}
