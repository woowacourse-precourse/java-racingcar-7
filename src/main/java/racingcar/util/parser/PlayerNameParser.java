package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;

public class PlayerNameParser {
    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }
}
