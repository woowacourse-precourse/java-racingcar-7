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
        hasMorThanOneCar(names);
        validateNames(names);

        return names;
    }

    private void hasMorThanOneCar(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNames(List<String> names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private void checkNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}