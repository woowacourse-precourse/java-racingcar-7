package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitter {
    private static final String DELIMITER = ",";

    public List<String> split(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.stream(input.split(DELIMITER))
                .map(String::strip)
                .filter(this::isNotEmpty)
                .toList();
    }

    private boolean isNotEmpty(String name) {
        return !name.isEmpty();
    }
}
