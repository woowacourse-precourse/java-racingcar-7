package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class NameParser {

    private static final String DELIMITER = ",";

    private final String input;

    public NameParser(String input) {
        this.input = input;
    }

    public List<String> parse() {
        List<String> names = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .toList();

        return names;
    }
}
